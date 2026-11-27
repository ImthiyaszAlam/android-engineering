# ViewModel Internals

## 1. Interview-ready introduction

ViewModel is owner-scoped screen state and logic, not persistence. ViewModelProvider checks a keyed ViewModelStore for an existing instance, or creates through a Factory. Store retention through configuration recreation is AndroidX behavior. Process death destroys the object; SavedStateHandle can restore small values into a new instance, while repository/database restores durable data. I keep UI references out and expose immutable state.

## 2. Core concepts and terminology

ViewModelStoreOwner (Activity, Fragment, NavBackStackEntry) provides a ViewModelStore. ViewModelProvider resolves key, returns existing instance or delegates to Factory and stores it. During configuration recreation, the store is retained/re-attached; on permanent owner removal it is cleared, invoking `onCleared` and cancelling `viewModelScope`. Navigation-scoped ViewModel follows its back-stack entry. SavedStateHandle integrates with saved-state registry and is not a database. Factories/creation extras matter when injecting dependencies and SavedStateHandle. `onCleared` is not guaranteed on process kill.

## 3. Internal Android implementation and architecture

ViewModelStoreOwner (Activity, Fragment, NavBackStackEntry) provides a ViewModelStore. ViewModelProvider resolves key, returns existing instance or delegates to Factory and stores it. During configuration recreation, the store is retained/re-attached; on permanent owner removal it is cleared, invoking `onCleared` and cancelling `viewModelScope`. Navigation-scoped ViewModel follows its back-stack entry. SavedStateHandle integrates with saved-state registry and is not a database. Factories/creation extras matter when injecting dependencies and SavedStateHandle. `onCleared` is not guaranteed on process kill.

## 4. Step-by-step execution flow

ViewModelStoreOwner (Activity, Fragment, NavBackStackEntry) provides a ViewModelStore. ViewModelProvider resolves key, returns existing instance or delegates to Factory and stores it. During configuration recreation, the store is retained/re-attached; on permanent owner removal it is cleared, invoking `onCleared` and cancelling `viewModelScope`. Navigation-scoped ViewModel follows its back-stack entry. SavedStateHandle integrates with saved-state registry and is not a database. Factories/creation extras matter when injecting dependencies and SavedStateHandle. `onCleared` is not guaranteed on process kill.

## 5. Architecture / lifecycle diagrams

```text
ViewModelStoreOwner → ViewModelProvider → lookup key
                                      ├─ found → reuse instance
                                      └─ absent → Factory → store instance
Config recreation: same store retained; new UI attaches
Process death: objects gone → new VM + SavedStateHandle + repository reload
Owner cleared: ViewModelStore.clear → onCleared / scope cancellation
```

## 6. Kotlin examples

```kotlin
class SearchVM(private val saved: SavedStateHandle, private val repo: SearchRepo) : ViewModel() {
  val query = saved.getStateFlow("query", "")
  val ui = query.flatMapLatest(repo::search)
    .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), SearchUi.Loading)
  fun setQuery(q: String) { saved["query"] = q }
}
```
Inject dependencies through a Factory/DI integration that preserves saved-state creation extras. Use saved IDs and reload current data; do not save large domain objects.

## 7. Real-world application use cases and implementation scenarios

- Search/filter state: SavedStateHandle and repository-backed Flow.
- Shared multi-fragment flow: navigation graph owner when lifetime matches graph.
- Rotation: same retained store, new UI observes state.
- Process death: reconstruct from saved ID plus database/server.
- Cleanup: cancel jobs, close owned resources when store clears.

## 8. Common mistakes and misconceptions

- Treating a component/API guarantee as stronger than platform policy.
- Performing blocking or expensive work on the main thread.
- Using in-memory state as a substitute for durable state.
- Ignoring ownership, cancellation, permission, or cleanup boundaries.
- Assuming exact behavior without specifying Android release, target SDK, process/task state, and caller context.

## 9. Deep technical edge cases

Key and owner define instance identity; same key in different owners gives different VMs. Graph-scoped VM clears when graph entry is popped. SavedStateHandle is snapshot restoration, not guaranteed durable data. viewModelScope cancellation is cooperative. Factory must preserve creation extras for saved state. UI/context references can leak. `onCleared` not guaranteed on process kill.

## 10. Performance and memory considerations

Avoid duplicate caches and large state. Use immutable StateFlow, cancellation, appropriate dispatcher, and WhileSubscribed where suitable. Scope navigation VMs intentionally to avoid excessive lifetime.

## 11. Debugging and troubleshooting

Log VM identity, owner and key; test rotation versus process recreation; inspect job cancellation and saved-state restoration. LeakCanary if retained VM references Activity/view. Unit test state using fake repo and test dispatcher.

## 12. Comparison with related components and APIs

| Tool | Survives config | Survives process |
|---|---:|---:|
| ViewModel | Yes | No object |
| SavedStateHandle | Yes | snapshot may restore |
| Database/DataStore | Yes | Yes |
| Activity/Fragment view | No | No |

AndroidX ViewModel/Provider/Store; framework does not instantiate VM.

## 13. Interview questions with detailed answers

### 1. What problem does ViewModel solve?

It separates UI state/work from view instances and survives configuration recreation through retained owner store.

### 2. ViewModelProvider internals

Provider uses owner store and key; returns stored instance or asks Factory, then stores it. Owner and key determine identity.

### 3. What is ViewModelStore?

Keyed holder of ViewModels, retained through configuration changes and cleared when owner is permanently released.

### 4. Who is ViewModelStoreOwner?

An Activity, Fragment, or navigation entry that supplies ViewModelStore; scope follows that owner.

### 5. Does ViewModel survive process death?

No object survival. System may restore saved-state values into a newly constructed ViewModel; fields and coroutines are gone.

### 6. SavedStateHandle purpose and limits

Small state values for reconstruction (query, selected ID). Saved-state mechanism has size/serialization limits and is not durable database.

### 7. What is onCleared?

Cleanup hook when store clears. It cancels viewModelScope, but abrupt process death may skip callback.

### 8. viewModelScope cancellation

Coroutine scope tied to VM; cancellation on clear is cooperative. Blocking calls must be cancellable or dispatched correctly.

### 9. Share ViewModel between Fragments

Choose common Activity owner or NavBackStackEntry/graph owner; select scope based on intended sharing and lifetime.

### 10. How does it survive rotation?

AndroidX retains ViewModelStore across configuration recreation; new Activity/Fragment obtains existing keyed instance.

### 11. How inject dependencies and SavedStateHandle?

Use Factory/DI, preserve creation extras for SavedStateHandle; do not manually construct VM in view.

### 12. Can ViewModel hold Context?

Avoid Activity, View, binding, lifecycle owner. Application context only when appropriate; prefer injected repositories.

### 13. Common ViewModel leaks

Callbacks/listeners holding UI, Activity context, unbounded caches or jobs. Check retained paths and LeakCanary.

### 14. Navigation-scoped lifetime

Store clears when entry popped; VMs and jobs in that scope are released.

### 15. How test ViewModel?

Unit-test state transitions with fakes and test dispatcher; integration-test owner scoping/restoration.

### 16. ViewModel versus persistence

VM is in-memory config resilient; database/files/server are durable. SavedStateHandle helps reconstruct but is not source of truth.

## 14. Challenging follow-up questions

- How is ViewModelStore retained across recreation conceptually?
- Factory creation extras and SavedStateHandle integration?
- Compare Fragment, Activity and nav-entry scopes.
- How can a callback leak a ViewModel owner?
- When might upstream Flow stop with WhileSubscribed?

For deeper follow-ups, state the Android version/target assumptions, draw the state or object/transaction flow, explain the trade-off, and say how you would test or inspect the behavior.

## 15. Final concise interview answer

ViewModelProvider uses owner store and Factory to reuse/create keyed instances. ViewModelStore retention handles configuration changes but process death destroys object. SavedStateHandle restores compact state; repositories persist domain data. I avoid UI references and use viewModelScope cancellation.

## Revision checklist

- [ ] Can explain the introduction in 60–90 seconds.
- [ ] Can redraw and narrate the diagram.
- [ ] Can explain internal behavior and distinguish framework from library behavior.
- [ ] Can walk through the Kotlin example and edge cases.
- [ ] Can answer the 15 questions and defend follow-up trade-offs.
- [ ] Can describe a debugging approach and the evidence/tool needed.

---

*Platform behavior may vary by Android release, target SDK, device/OEM and runtime context. Validate policy-specific behavior against the interview scenario.*
