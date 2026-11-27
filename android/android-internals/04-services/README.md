# Services

## 1. Interview-ready introduction

Service is a component for work or client interaction not directly bound to a visible Activity; it is not a thread. Started and bound semantics differ. Service callbacks execute on main unless work is dispatched. Foreground service is reserved for user-noticeable ongoing work with notification, type, permissions, and start eligibility. WorkManager is usually for deferrable persistent work; JobScheduler schedules system jobs under constraints.

## 2. Core concepts and terminology

Started service receives start intents and remains started until stopped or system termination. Bound service exposes IBinder to clients; binding affects lifetime. Both states can coexist. `onCreate` once per instance, `onStartCommand` per start request, `onBind` for binding, `onUnbind` when clients detach, and `onDestroy` on normal teardown. FGS promotion must comply with platform deadlines, type/permission, notification, and background-start restrictions. `START_STICKY`, `START_NOT_STICKY`, and `START_REDELIVER_INTENT` are restart policies, not guarantees. Service work is process-bound unless work is persisted/scheduled.

## 3. Internal Android implementation and architecture

Started service receives start intents and remains started until stopped or system termination. Bound service exposes IBinder to clients; binding affects lifetime. Both states can coexist. `onCreate` once per instance, `onStartCommand` per start request, `onBind` for binding, `onUnbind` when clients detach, and `onDestroy` on normal teardown. FGS promotion must comply with platform deadlines, type/permission, notification, and background-start restrictions. `START_STICKY`, `START_NOT_STICKY`, and `START_REDELIVER_INTENT` are restart policies, not guarantees. Service work is process-bound unless work is persisted/scheduled.

## 4. Step-by-step execution flow

Started service receives start intents and remains started until stopped or system termination. Bound service exposes IBinder to clients; binding affects lifetime. Both states can coexist. `onCreate` once per instance, `onStartCommand` per start request, `onBind` for binding, `onUnbind` when clients detach, and `onDestroy` on normal teardown. FGS promotion must comply with platform deadlines, type/permission, notification, and background-start restrictions. `START_STICKY`, `START_NOT_STICKY`, and `START_REDELIVER_INTENT` are restart policies, not guarantees. Service work is process-bound unless work is persisted/scheduled.

## 5. Architecture / lifecycle diagrams

```text
startService/startForegroundService → onCreate → onStartCommand
                                          └─ dispatch worker
bindService → onBind → IBinder ↔ client calls → onUnbind
Started state: stopSelf(startId) / stopService
Bound state: clients unbind
Normal stop: onDestroy
Persistent deferrable job: WorkManager/JobScheduler instead
```

## 6. Kotlin examples

```kotlin
class UploadService : Service() {
  private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
  override fun onStartCommand(intent: Intent?, flags: Int, id: Int): Int {
    val key = intent?.getStringExtra("key") ?: return START_NOT_STICKY
    scope.launch { try { upload(key) } finally { stopSelf(id) } }
    return START_NOT_STICKY
  }
  override fun onBind(intent: Intent?) = null
  override fun onDestroy() { scope.cancel(); super.onDestroy() }
}
```
Illustrative only: durable deferred upload should usually use WorkManager; user-noticeable ongoing work must meet current FGS type, permission, notification and start rules.

## 7. Real-world application use cases and implementation scenarios

- Playback/navigation: user-noticeable foreground service only with correct current type and notification.
- Bound API: clients bind to a local/remote interface.
- Upload/sync: WorkManager with constraints, retry and persistence.
- Start IDs and stable work IDs prevent duplicate completion issues.
- Service does not imply background thread.

## 8. Common mistakes and misconceptions

- Treating a component/API guarantee as stronger than platform policy.
- Performing blocking or expensive work on the main thread.
- Using in-memory state as a substitute for durable state.
- Ignoring ownership, cancellation, permission, or cleanup boundaries.
- Assuming exact behavior without specifying Android release, target SDK, process/task state, and caller context.

## 9. Deep technical edge cases

Started and bound state can coexist; stopping started state does not destroy while clients remain bound. Sticky recreation can deliver null Intent. FGS types/permissions/start restrictions vary by Android release/target. Local Binder may execute on caller thread. Redelivery/retry can duplicate side effects.

## 10. Performance and memory considerations

Dispatch blocking work to IO or worker; limit concurrency; avoid unnecessary wake locks; notification should accurately communicate ongoing work. Persistent deferrable work should be scheduled rather than holding process alive.

## 11. Debugging and troubleshooting

Inspect manifest, exported, FGS type/permissions, notification channel, start eligibility and logcat. Log startId/work key. Diagnose worker constraints separately from service state; inspect main-thread blocking.

## 12. Comparison with related components and APIs

| API | Use | Durability |
|---|---|---|
| Started Service | component work | not durable by itself |
| Bound Service | client API | client bindings |
| Foreground Service | ongoing user-visible task | still policy/process bound |
| WorkManager | deferred persistent work | persisted schedule |
| JobScheduler | system scheduled job | flexible timing |

Service framework; WorkManager AndroidX abstraction.

## 13. Interview questions with detailed answers

### 1. Is a Service a thread?

No. Component callbacks run on main by default; dispatch CPU/IO work.

### 2. Started versus bound

Started receives start requests; bound exposes Binder to clients and lifecycle is influenced by binding. Can be both.

### 3. startService versus startForegroundService

Start request versus request to promote; FGS must promptly promote with valid notification/type and satisfy current policies.

### 4. onStartCommand return values

NOT_STICKY no automatic recreation; STICKY may recreate with null intent; REDELIVER requests last intent redelivery. All are hints/policies, not exactly-once guarantees.

### 5. When use foreground service?

User-noticeable ongoing work (navigation, playback, qualifying recording/connected device). Correct type/permission/notification/start eligibility; not a keep-alive loophole.

### 6. Why WorkManager for upload?

WorkManager persists job definition, constraints, retry and rescheduling. Service itself is process-bound and not durable scheduling.

### 7. What does onBind return?

IBinder, local Binder or remote AIDL/Messenger interface; null if no bind contract.

### 8. Service lifecycle sequence

onCreate once, start callback per start, bind/unbind callbacks, normal stop calls onDestroy. Started/bound states can overlap.

### 9. How stop safely?

Use stopSelf(startId) after that request to avoid older work stopping newer starts; bound clients also affect lifetime.

### 10. START_STICKY behavior

May recreate without original intent; reconstruct from persistent state and make work idempotent.

### 11. Background service restrictions

Modern Android limits background starts and FGS starts/types. Use approved schedulers and check target SDK/platform.

### 12. Can service callbacks block?

Yes: main thread callbacks by default; blocking causes UI stall/ANR.

### 13. Duplicate intents and idempotency

Persist work IDs, dedupe, make operations idempotent; redelivery/retries can repeat side effects.

### 14. Local bound service

Local Binder for same process; direct calls can be caller-thread and require thread safety.

### 15. Diagnose service not starting

Manifest, exported/type/permission, notification channel, start eligibility, logcat policy errors; distinguish Service from scheduler job.

## 14. Challenging follow-up questions

- Design idempotent service intent handling across redelivery.
- Compare sticky and redeliver policies for partial upload.
- Why can FGS start be rejected?
- Migrate task from Service to WorkManager.
- Thread-safety contract for local Binder?

For deeper follow-ups, state the Android version/target assumptions, draw the state or object/transaction flow, explain the trade-off, and say how you would test or inspect the behavior.

## 15. Final concise interview answer

Service is component, not thread. Started and bound semantics differ. FGS is for user-noticeable work and must meet notification/type/permission/start policy. I dispatch work off main and use WorkManager for deferrable durable jobs, handling process death and duplicate starts.

## Revision checklist

- [ ] Can explain the introduction in 60–90 seconds.
- [ ] Can redraw and narrate the diagram.
- [ ] Can explain internal behavior and distinguish framework from library behavior.
- [ ] Can walk through the Kotlin example and edge cases.
- [ ] Can answer the 15 questions and defend follow-up trade-offs.
- [ ] Can describe a debugging approach and the evidence/tool needed.

---

*Platform behavior may vary by Android release, target SDK, device/OEM and runtime context. Validate policy-specific behavior against the interview scenario.*
