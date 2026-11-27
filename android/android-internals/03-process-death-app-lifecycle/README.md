# Process Death & App Lifecycle

## 1. Interview-ready introduction

Android controls process lifetime. Components share a process unless configured otherwise; system importance depends on visible/foreground components and work. Cached/background processes may be reclaimed under memory pressure without callbacks. Heap, static state, threads, singleton caches and active jobs vanish. I persist domain data continuously and reconstruct from storage plus compact saved UI state. Force-stop is package-stopped behavior and is not the same as ordinary process reclamation.

## 2. Core concepts and terminology

App process commonly starts from Zygote and is managed by ActivityManager/system policy. Importance reflects component state and dependencies; foreground/visible processes are generally less reclaimable than cached ones. Low-memory mechanisms including lmkd/kernel pressure policy select victims, details vary by release/device. Task records can remain in Recents when process is gone. Restore path may create a new process/Activity. Database, files, DataStore, server survive process loss; ViewModels, statics, thread stacks, in-memory caches do not. Saved state is conditional system reconstruction, not guaranteed persistence. Force-stop suppresses many background starts until user/policy action.

## 3. Internal Android implementation and architecture

App process commonly starts from Zygote and is managed by ActivityManager/system policy. Importance reflects component state and dependencies; foreground/visible processes are generally less reclaimable than cached ones. Low-memory mechanisms including lmkd/kernel pressure policy select victims, details vary by release/device. Task records can remain in Recents when process is gone. Restore path may create a new process/Activity. Database, files, DataStore, server survive process loss; ViewModels, statics, thread stacks, in-memory caches do not. Saved state is conditional system reconstruction, not guaranteed persistence. Force-stop suppresses many background starts until user/policy action.

## 4. Step-by-step execution flow

App process commonly starts from Zygote and is managed by ActivityManager/system policy. Importance reflects component state and dependencies; foreground/visible processes are generally less reclaimable than cached ones. Low-memory mechanisms including lmkd/kernel pressure policy select victims, details vary by release/device. Task records can remain in Recents when process is gone. Restore path may create a new process/Activity. Database, files, DataStore, server survive process loss; ViewModels, statics, thread stacks, in-memory caches do not. Saved state is conditional system reconstruction, not guaranteed persistence. Force-stop suppresses many background starts until user/policy action.

## 5. Architecture / lifecycle diagrams

```text
Foreground → user leaves → cached/background importance drops
                          │ memory pressure
                          ▼
                 process killed (no callback)
           heap/statics/threads/coroutines lost
                          │ later launch/task restore
                          ▼
              new process + component instances
           durable repository + saved UI snapshot
```

## 6. Kotlin examples

```kotlin
class CartVM(private val saved: SavedStateHandle, private val repo: CartRepo) : ViewModel() {
  val cartId: String? = saved["cartId"]
  val cart = cartId?.let { repo.observeCart(it) } // Re-read durable source.
  fun saveDraft(draft: CartDraft) = viewModelScope.launch { repo.persistDraft(draft) }
}
```
Store stable IDs in saved state, validate existence/authentication on restore, and persist drafts in repository. Use WorkManager for deferrable persistent work; process-owned threads do not survive kill.

## 7. Real-world application use cases and implementation scenarios

- Cart/order: persist on change in database/server.
- Screen restoration: save stable IDs, re-query, validate existence.
- Upload: WorkManager with retry/constraints; no process-owned thread.
- Task may remain in Recents with PID changed.
- Force-stop testing separately from ordinary kill.

## 8. Common mistakes and misconceptions

- Treating a component/API guarantee as stronger than platform policy.
- Performing blocking or expensive work on the main thread.
- Using in-memory state as a substitute for durable state.
- Ignoring ownership, cancellation, permission, or cleanup boundaries.
- Assuming exact behavior without specifying Android release, target SDK, process/task state, and caller context.

## 9. Deep technical edge cases

Process may be killed without onDestroy. Task record can persist while process is absent. Force-stop sets stopped package state and restricts background triggers. Saved state can be absent on crash/force-stop/user-cleared data. OEM battery policy may differ. Cached-process importance is not a survival guarantee.

## 10. Performance and memory considerations

Keep memory caches bounded/reconstructable. Persist incremental changes, avoid synchronous startup IO, use cold/warm start metrics, restore with repository async and stable identifiers.

## 11. Debugging and troubleshooting

Use adb process kill vs force-stop tests; log PID, component and restoration IDs; verify DB; inspect WorkManager/job state; test task/launcher/notification/deep-link entry separately.

## 12. Comparison with related components and APIs

| State | Ordinary process kill | Force-stop/data clear |
|---|---|---|
| Heap/statics/jobs | Lost | Lost |
| Database/files | Remain | Remain after force-stop; data clear deletes |
| Task/Recents | May remain | task/start behavior restricted |
| Scheduled work | system-managed, policy-dependent | triggers restricted until allowed start |

Framework process management vs AndroidX saved-state snapshot.

## 13. Interview questions with detailed answers

### 1. What is process death?

System terminates app Linux process, losing in-memory state and work; later components may be recreated.

### 2. Does onDestroy run before process kill?

No guarantee. onDestroy is lifecycle teardown, not a process-shutdown hook. Save meaningful state earlier.

### 3. Process importance

Priority concept based on active components and relationships. Foreground/visible generally less reclaimable; exact policy changes.

### 4. LMK/lmkd concept

Low-memory reclaim mechanisms include lmkd and kernel pressure signals; implementation evolves. Apps should tolerate termination, not rely on kill order.

### 5. What survives process death?

Durable storage remains. Saved-state snapshot may restore. ViewModel, statics, singleton heap state, threads, and active jobs are gone.

### 6. Process death versus Activity recreation

Activity recreation occurs within process and can retain VM store. Process death removes all objects and reconstructs fresh instances.

### 7. Force-stop versus ordinary kill

Ordinary kill reclaims process but package remains eligible under policies. Force-stop marks package stopped and suppresses many triggers until explicit start/allowed action.

### 8. How restore app state?

Durable domain data in repository/database; small UI state in Bundle/SavedStateHandle; validate IDs and refresh.

### 9. Does WorkManager survive process death?

WorkManager persists work definition/scheduling and reschedules under policy, but not exact execution time or guarantee of immediate run.

### 10. Task in Recents and process existence

Task/Recents records can remain while process is dead; restoring task creates process/Activity again.

### 11. Cold versus warm start

Cold start initializes process; warm start reuses process but may create Activity. Measure separate paths.

### 12. Why not save only in onStop?

Abrupt kill can happen before callback; incremental persistence avoids losing latest important state.

### 13. Simulate process death

Avoid large graphs, bitmaps, secrets, and durable business data. Store compact IDs/preferences only.

### 14. Saved-state data that should not be stored

OEM battery policy may add delays/restrictions; test target devices and use supported scheduling.

### 15. OEM background policy effects

Persist checkpoints; idempotent operations; reconstruct screen from repository; treat memory as cache.

## 14. Challenging follow-up questions

- How do task records survive process loss?
- What happens if restored ID is stale or auth expired?
- Why is adb force-stop not equivalent to process kill?
- What work should use WorkManager rather than Service?
- Explain foreground process importance without claiming guaranteed survival.

For deeper follow-ups, state the Android version/target assumptions, draw the state or object/transaction flow, explain the trade-off, and say how you would test or inspect the behavior.

## 15. Final concise interview answer

Process lifetime belongs to system. Background process can be reclaimed without callbacks. I persist domain state, save compact restoration state, and rebuild fresh components. ViewModels/statics/jobs are volatile. Force-stop differs because package is stopped and background execution is restricted.

## Revision checklist

- [ ] Can explain the introduction in 60–90 seconds.
- [ ] Can redraw and narrate the diagram.
- [ ] Can explain internal behavior and distinguish framework from library behavior.
- [ ] Can walk through the Kotlin example and edge cases.
- [ ] Can answer the 15 questions and defend follow-up trade-offs.
- [ ] Can describe a debugging approach and the evidence/tool needed.

---

*Platform behavior may vary by Android release, target SDK, device/OEM and runtime context. Validate policy-specific behavior against the interview scenario.*
