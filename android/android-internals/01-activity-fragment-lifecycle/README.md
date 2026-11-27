# Activity & Fragment Lifecycle

## 1. Interview-ready introduction

I explain lifecycle as Android-managed ownership transitions. An Activity owns a window/screen entry point; a Fragment is managed by FragmentManager and may have a view whose lifetime is shorter than the Fragment object. Callbacks are for attaching, starting, pausing, stopping, and releasing resources—not reliable persistence hooks. I restore compact transient state from saved-state APIs and durable/domain state from repositories.

## 2. Core concepts and terminology

Created (`onCreate`), Started (`onStart`, visible), Resumed (`onResume`, interactive), Paused (`onPause`, loses focus but can remain visible), Stopped (`onStop`, not visible), Destroyed (`onDestroy`, instance teardown). Activity A→B usually pauses A, creates/starts/resumes B, then stops A if B fully obscures it. Returning from B restarts/starts/resumes A if stopped. Rotation normally destroys/recreates Activity: old `onPause/onStop/onDestroy`, new `onCreate/onStart/onResume`; saved-state timing is not a universal shutdown guarantee. Fragment object lifecycle and view lifecycle differ: `onDestroyView` can occur while Fragment remains on back stack. Use `viewLifecycleOwner` for UI observation and clear binding in `onDestroyView`. FragmentManager owns transactions/back stack; lifecycle is AndroidX observer infrastructure, not immortality.

## 3. Internal Android implementation and architecture

Created (`onCreate`), Started (`onStart`, visible), Resumed (`onResume`, interactive), Paused (`onPause`, loses focus but can remain visible), Stopped (`onStop`, not visible), Destroyed (`onDestroy`, instance teardown). Activity A→B usually pauses A, creates/starts/resumes B, then stops A if B fully obscures it. Returning from B restarts/starts/resumes A if stopped. Rotation normally destroys/recreates Activity: old `onPause/onStop/onDestroy`, new `onCreate/onStart/onResume`; saved-state timing is not a universal shutdown guarantee. Fragment object lifecycle and view lifecycle differ: `onDestroyView` can occur while Fragment remains on back stack. Use `viewLifecycleOwner` for UI observation and clear binding in `onDestroyView`. FragmentManager owns transactions/back stack; lifecycle is AndroidX observer infrastructure, not immortality.

## 4. Step-by-step execution flow

Created (`onCreate`), Started (`onStart`, visible), Resumed (`onResume`, interactive), Paused (`onPause`, loses focus but can remain visible), Stopped (`onStop`, not visible), Destroyed (`onDestroy`, instance teardown). Activity A→B usually pauses A, creates/starts/resumes B, then stops A if B fully obscures it. Returning from B restarts/starts/resumes A if stopped. Rotation normally destroys/recreates Activity: old `onPause/onStop/onDestroy`, new `onCreate/onStart/onResume`; saved-state timing is not a universal shutdown guarantee. Fragment object lifecycle and view lifecycle differ: `onDestroyView` can occur while Fragment remains on back stack. Use `viewLifecycleOwner` for UI observation and clear binding in `onDestroyView`. FragmentManager owns transactions/back stack; lifecycle is AndroidX observer infrastructure, not immortality.

## 5. Architecture / lifecycle diagrams

```text
Activity: onCreate → onStart → onResume
                          ↓ loses focus
                       onPause (may remain visible)
                          ↓ invisible
                        onStop
                 ↙ return     ↘ finish/recreate
             onRestart        onDestroy
                 ↓
              onStart → onResume

Fragment object: onCreate ---------------------- onDestroy
View lifetime:       onCreateView ---- onDestroyView
```
**Fragment binding:**

## 6. Kotlin examples

```kotlin
class DetailFragment : Fragment(R.layout.detail) {
  private var _binding: DetailBinding? = null
  private val binding get() = requireNotNull(_binding)
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    _binding = DetailBinding.bind(view)
    viewModel.state.observe(viewLifecycleOwner) { binding.title.text = it.title }
  }
  override fun onDestroyView() { _binding = null; super.onDestroyView() }
}
```
Keep small selection/scroll values in saved state; persist business data separately. Do not put bitmaps or large graphs in Bundle.

## 7. Real-world application use cases and implementation scenarios

- Rotation: keep selected ID/filter in saved state or ViewModel; reload data from repository.
- Activity A launches B: A pauses, B starts/resumes; A stops only if hidden.
- Fragment back-stack: view can be destroyed and rebuilt while Fragment object remains.
- Camera/sensors/animation: acquire and release according to visibility/focus ownership.
- Multi-window: visible is not always resumed.

## 8. Common mistakes and misconceptions

- Treating a component/API guarantee as stronger than platform policy.
- Performing blocking or expensive work on the main thread.
- Using in-memory state as a substitute for durable state.
- Ignoring ownership, cancellation, permission, or cleanup boundaries.
- Assuming exact behavior without specifying Android release, target SDK, process/task state, and caller context.

## 9. Deep technical edge cases

Translucent Activity may leave previous Activity visible; multi-window changes focus/visibility assumptions; Fragment transaction after saved state may fail or lose state; process kill bypasses callbacks; Bundle is size-limited; use repeatOnLifecycle for Flow; saved state may not be provided on every exit.

## 10. Performance and memory considerations

Keep callbacks short, avoid repeated setup on every resume, cancel lifecycle-bound work, release sensors/camera, avoid retained view trees. Restore screen from compact state rather than redoing expensive synchronous work.

## 11. Debugging and troubleshooting

Log callback timestamps, object identity and task/fragment state. Reproduce rotation, back-stack, background/foreground, multi-window and process recreation separately. LeakCanary for retained views; inspect FragmentManager and lifecycle observer ownership.

## 12. Comparison with related components and APIs

| Component | Scope | State strategy |
|---|---|---|
| Activity | window/task entry | saved state + VM/repository |
| Fragment | host-managed controller | fragment state + VM |
| Fragment view | view creation to onDestroyView | viewLifecycleOwner; clear binding |
| ViewModel | owner store | memory across config, not process |

Framework callbacks are Activity; Fragment/Lifecycle are AndroidX.

## 13. Interview questions with detailed answers

### 1. Describe Activity lifecycle

A Activity is created, started, resumed; pause means loses focus, stop means invisible, restart precedes start when returning. Destruction is normal teardown but not guaranteed on process kill.

### 2. What occurs when A launches B?

A typically pauses; B creates/starts/resumes. A stops only if no longer visible. A translucent or multi-window B can leave A visible/paused. Return transitions depend on whether A was stopped.

### 3. Rotation and configuration change

Unless handled, configuration change recreates Activity. The new instance gets saved-state data; ViewModel may be retained by its owner. Views are rebuilt.

### 4. onPause versus onStop

Paused loses focus but can still be visible. Stopped is no longer visible. Scope focus-sensitive resources and visibility-bound resources accordingly.

### 5. Fragment versus Fragment view lifecycle

Fragment can outlive its view. View lifecycle ends at onDestroyView; Fragment lifecycle may continue while back-stacked. UI observation should bind to view owner.

### 6. Why clear binding in onDestroyView?

Binding strongly references the view tree; clearing it releases the Fragment-held path to old views when view is destroyed.

### 7. What is saved instance state for?

Small transient reconstruction state such as selected ID or tab. Not durable storage and not guaranteed on every exit.

### 8. Is onDestroy guaranteed?

No. Abrupt process termination can bypass callbacks; do not make persistence depend on onDestroy.

### 9. What happens when Fragment is back-stacked?

Fragment may remain while view is removed/destroyed. Recreate from state when popped; do not retain view references.

### 10. What is multi-window lifecycle nuance?

Visible and resumed are not synonymous. Multi-window or overlays can leave an Activity visible without exclusive interaction.

### 11. Why use viewLifecycleOwner?

It ends observation when view lifecycle ends, preventing collectors from updating a dead view and reducing leaks.

### 12. How should Flow be lifecycle-collected?

Use repeatOnLifecycle at suitable state; collection cancels below that state and restarts when lifecycle rises.

### 13. What does FragmentManager manage?

It manages Fragment instances, transactions, saved state, and Fragment back stack, coordinating host lifecycle.

### 14. What is Fragment transaction state loss?

Commit after state snapshot can produce state loss. Schedule before state saved; allowing state loss is an explicit trade-off, not a default fix.

### 15. How test lifecycle edge cases?

Test rotation, background/foreground, process recreation, multi-window, rapid navigation, and back stack; log instance IDs and inspect leaks.

## 14. Challenging follow-up questions

- Explain lifecycle with callbacks and why state must not depend on onDestroy.
- Draw A→B lifecycle for opaque and translucent B.
- What state is held by Fragment while view is destroyed?
- Why can a lifecycle observer still leak?
- How do configuration changes differ from process death?

For deeper follow-ups, state the Android version/target assumptions, draw the state or object/transaction flow, explain the trade-off, and say how you would test or inspect the behavior.

## 15. Final concise interview answer

Lifecycle is ownership: Activity follows screen/window state, Fragment has a view lifetime that can end before Fragment object. I scope UI observers and bindings to view lifecycle, use ViewModel across configuration recreation, saved state for small reconstruction values and repository for durable data. Destruction callbacks are not guaranteed on process kill.

## Revision checklist

- [ ] Can explain the introduction in 60–90 seconds.
- [ ] Can redraw and narrate the diagram.
- [ ] Can explain internal behavior and distinguish framework from library behavior.
- [ ] Can walk through the Kotlin example and edge cases.
- [ ] Can answer the 15 questions and defend follow-up trade-offs.
- [ ] Can describe a debugging approach and the evidence/tool needed.

---

*Platform behavior may vary by Android release, target SDK, device/OEM and runtime context. Validate policy-specific behavior against the interview scenario.*
