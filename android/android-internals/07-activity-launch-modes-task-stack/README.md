# Activity Launch Modes & Task Stack

## 1. Interview-ready introduction

Navigation is task and Activity-record management, not merely a list of screens in one process. Launch modes, Intent flags, task affinity, and caller context determine whether Android creates, reuses, clears, or fronts an instance/task. I draw the stack and identify the target instance before predicting callbacks. Notification and deep-link paths need explicit back-stack design and tests from cold, warm, and existing task states.

## 2. Core concepts and terminology

Task is logical Activity record stack and can remain in Recents while process is dead. `standard` creates new instance; `singleTop` reuses only if already top; `singleTask` task-level reuse/clearing under rules; `singleInstance` specialized isolation. Intent flags (`NEW_TASK`, `CLEAR_TOP`, `SINGLE_TOP`, `CLEAR_TASK`) affect launch, not manifest mode. Affinity is task preference, not security. Reuse may invoke `onNewIntent`, not `onCreate`; call `setIntent` if latest intent should be returned by getIntent. Fragment/Nav back stack is separate from OS task stack.

## 3. Internal Android implementation and architecture

Task is logical Activity record stack and can remain in Recents while process is dead. `standard` creates new instance; `singleTop` reuses only if already top; `singleTask` task-level reuse/clearing under rules; `singleInstance` specialized isolation. Intent flags (`NEW_TASK`, `CLEAR_TOP`, `SINGLE_TOP`, `CLEAR_TASK`) affect launch, not manifest mode. Affinity is task preference, not security. Reuse may invoke `onNewIntent`, not `onCreate`; call `setIntent` if latest intent should be returned by getIntent. Fragment/Nav back stack is separate from OS task stack.

## 4. Step-by-step execution flow

Task is logical Activity record stack and can remain in Recents while process is dead. `standard` creates new instance; `singleTop` reuses only if already top; `singleTask` task-level reuse/clearing under rules; `singleInstance` specialized isolation. Intent flags (`NEW_TASK`, `CLEAR_TOP`, `SINGLE_TOP`, `CLEAR_TASK`) affect launch, not manifest mode. Affinity is task preference, not security. Reuse may invoke `onNewIntent`, not `onCreate`; call `setIntent` if latest intent should be returned by getIntent. Fragment/Nav back stack is separate from OS task stack.

## 5. Architecture / lifecycle diagrams

```text
Task: Home → Catalog → Product
standard launch Product: Home → Catalog → Product → Product(new)
singleTop if Product at top: Home → Catalog → Product(existing) [onNewIntent]
CLEAR_TOP targeting Catalog: Home → Catalog (records above cleared; reuse/recreate depends on mode/flags)
```

## 6. Kotlin examples

```kotlin
val intent = Intent(context, DetailActivity::class.java).apply {
  putExtra("id", id)
  // For non-Activity context, NEW_TASK may be required.
  flags = Intent.FLAG_ACTIVITY_NEW_TASK
}
context.startActivity(intent)

override fun onNewIntent(intent: Intent) {
  super.onNewIntent(intent); setIntent(intent)
  viewModel.open(intent.getStringExtra("id"))
}
```
Flags are examples, not universal stack recipe. Validate deep-link inputs and authorization; draw expected task before selecting flags.

## 7. Real-world application use cases and implementation scenarios

- Notification: construct parent/back stack and test cold/existing task.
- Deep link: validate URI, handle missing content, define back behavior.
- singleTop detail: refresh via onNewIntent.
- Auth: clear stack on login/logout deliberately.
- Test Recents, launcher, notification, in-app and multi-task contexts.

## 8. Common mistakes and misconceptions

- Treating a component/API guarantee as stronger than platform policy.
- Performing blocking or expensive work on the main thread.
- Using in-memory state as a substitute for durable state.
- Ignoring ownership, cancellation, permission, or cleanup boundaries.
- Assuming exact behavior without specifying Android release, target SDK, process/task state, and caller context.

## 9. Deep technical edge cases

singleTop only top instance. CLEAR_TOP can clear records and may recreate target without reuse flags. NEW_TASK uses task selection/affinity, not always brand-new task. singleTask has task-level effects. Intent and launch modes interact. Process can die while task survives. Predictive back/system navigation can change handling; do not conflate Fragment/Nav stack.

## 10. Performance and memory considerations

Pass stable IDs, not big parcelables. Avoid unnecessary Activity recreation/task clearing. Resolve deep-link data asynchronously and avoid sync IO in onCreate.

## 11. Debugging and troubleshooting

Log taskId, instance, intent flags, onNewIntent and callback order. Use task/activity diagnostics. Draw before/after stacks. Check manifest affinity and whether startActivity called from Activity or application context.

## 12. Comparison with related components and APIs

| Mode | Core behavior |
|---|---|
| standard | create new each launch |
| singleTop | reuse only if top |
| singleTask | reuse target/task under rules, may clear above |
| singleInstance | specialized isolated task semantics |

Flags are per-launch modifiers. ActivityTaskManager framework; NavController stack is library/local abstraction.

## 13. Interview questions with detailed answers

### 1. What is a task?

Task is logical Activity stack, independent from process; Recents can retain task records.

### 2. standard launch mode

Default creates each launch; duplicates can stack.

### 3. singleTop semantics

Reuse only when target already top; otherwise may create new. Not global singleton.

### 4. singleTask semantics

Task-level existing target can be brought forward and records above cleared; interactions with flags/context matter.

### 5. singleInstance mode

Specialized Activity isolation into task; rarely needed, can surprise navigation.

### 6. Task affinity

Task preference used for task selection/reparenting; not security identity.

### 7. NEW_TASK flag

Launch in task context, possibly selecting/creating task by affinity; not always “new task”.

### 8. CLEAR_TOP flag

Clear records above target. Target reuse/recreation depends launch mode and flags; combine deliberately.

### 9. When onNewIntent?

When existing Activity instance reused by launch flags/mode; process new data and setIntent if needed.

### 10. Notification navigation

Construct desired parent/back stack and PendingIntent flags; test cold and existing task, avoid empty/unexpected back.

### 11. Deep links and task stack

Deep link resolves destination; stack behavior depends task/flags/navigation. Validate URI/data.

### 12. Activity stack versus Fragment stack

System task stack across Activities/tasks vs FragmentManager host-local fragment transaction stack.

### 13. Why test onNewIntent?

Reused instance skips onCreate; stale state if processing only there. Refresh state from new Intent.

### 14. Clear login stack

Use explicit stack-clearing/navigation APIs/flags to establish authenticated root; test logout/cold start.

### 15. Debug back navigation

Log taskId, flags, instance IDs, onNewIntent; inspect manifest, caller context and separate fragment stack.

## 14. Challenging follow-up questions

- Draw CLEAR_TOP outcomes with and without SINGLE_TOP.
- Why singleTop is not a singleton?
- How NEW_TASK/affinity cause unexpected stack?
- Notification back stack for cold and existing task?
- Handle deep link to deleted item?

For deeper follow-ups, state the Android version/target assumptions, draw the state or object/transaction flow, explain the trade-off, and say how you would test or inspect the behavior.

## 15. Final concise interview answer

I model task records and stack mutations. Standard creates; singleTop reuses top; singleTask has task-level reuse/clear behavior; singleInstance is specialized. Intent flags and affinity change selection. I draw intended stack and handle onNewIntent for reused instances, then test cold, warm, deep-link, notification and Recents flows.

## Revision checklist

- [ ] Can explain the introduction in 60–90 seconds.
- [ ] Can redraw and narrate the diagram.
- [ ] Can explain internal behavior and distinguish framework from library behavior.
- [ ] Can walk through the Kotlin example and edge cases.
- [ ] Can answer the 15 questions and defend follow-up trade-offs.
- [ ] Can describe a debugging approach and the evidence/tool needed.

---

*Platform behavior may vary by Android release, target SDK, device/OEM and runtime context. Validate policy-specific behavior against the interview scenario.*
