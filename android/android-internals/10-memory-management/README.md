# Android Memory Management

## 1. Interview-ready introduction

Android memory includes managed heap, native allocations, graphics, mapped memory and runtime overhead. ART GC traces roots and reclaims unreachable objects, but reachable leaks remain. I manage ownership and lifetimes, bound caches, downsample images, release listeners and avoid Activity/view references in long-lived objects. I diagnose retained paths with heap dumps and LeakCanary, while considering process reclamation a normal response to memory pressure.

## 2. Core concepts and terminology

Strong references retain objects. Weak references do not prevent collection and may become null; soft-reference caches are unpredictable and not preferred. GC roots include stacks, statics, JNI/runtime references. Bitmap backing can be native/graphics and may not appear as ordinary heap size. OOM may result from heap/native limits, huge allocations, fragmentation, or pressure. lmkd/system can reclaim processes. Leak is unintended retention; allocation churn is frequent temporary allocation. Use bounded LRU caches, image resizing, paging, profilers, and leak paths—not indiscriminate pools.

## 3. Internal Android implementation and architecture

Strong references retain objects. Weak references do not prevent collection and may become null; soft-reference caches are unpredictable and not preferred. GC roots include stacks, statics, JNI/runtime references. Bitmap backing can be native/graphics and may not appear as ordinary heap size. OOM may result from heap/native limits, huge allocations, fragmentation, or pressure. lmkd/system can reclaim processes. Leak is unintended retention; allocation churn is frequent temporary allocation. Use bounded LRU caches, image resizing, paging, profilers, and leak paths—not indiscriminate pools.

## 4. Step-by-step execution flow

Strong references retain objects. Weak references do not prevent collection and may become null; soft-reference caches are unpredictable and not preferred. GC roots include stacks, statics, JNI/runtime references. Bitmap backing can be native/graphics and may not appear as ordinary heap size. OOM may result from heap/native limits, huge allocations, fragmentation, or pressure. lmkd/system can reclaim processes. Leak is unintended retention; allocation churn is frequent temporary allocation. Use bounded LRU caches, image resizing, paging, profilers, and leak paths—not indiscriminate pools.

## 5. Architecture / lifecycle diagrams

```text
GC roots (thread stack / static / JNI)
          │ strong paths
          ▼
reachable graph → retained, not collectible

Singleton → listener → Activity → View tree  [leak path]
Unreachable objects → eligible for GC (not instant)
Process memory: managed + native + graphics + mapped
```

## 6. Kotlin examples

```kotlin
class AppCache(context: Context) {
  private val appContext = context.applicationContext
  private val images = LruCache<String, Bitmap>(8 * 1024 * 1024) { it.byteCount }
  fun cache(key: String, image: Bitmap) { images.put(key, image) }
}
```
Use application context only for app-lifetime APIs. Bound caches by bytes, decode near display size, cancel requests and clear view references at owner teardown. Prefer established image libraries.

## 7. Real-world application use cases and implementation scenarios

- Feed images: downsample, bounded cache, cancel requests.
- Navigation: avoid singleton listeners retaining screens.
- Large data: paging/streaming instead of giant object graph.
- Native SDK: inspect JNI/native heap when Java heap is modest.
- Low memory: app remains reconstructable if process reclaimed.

## 8. Common mistakes and misconceptions

- Treating a component/API guarantee as stronger than platform policy.
- Performing blocking or expensive work on the main thread.
- Using in-memory state as a substitute for durable state.
- Ignoring ownership, cancellation, permission, or cleanup boundaries.
- Assuming exact behavior without specifying Android release, target SDK, process/task state, and caller context.

## 9. Deep technical edge cases

Bitmap may have native/graphics backing. Weak reference can clear anytime; SoftReference not dependable cache. OOM may arise native pressure or contiguous allocation. Pooling may retain memory. LeakCanary reports path, not every high-memory case. GC is not deterministic; set null is not immediate free. Process kill can follow memory pressure.

## 10. Performance and memory considerations

Bound caches in bytes, avoid allocation churn in hot path, decode target dimensions, paginate, release listeners and views, profile before pooling. Consider managed, native, graphics, mapped and total PSS/RSS categories.

## 11. Debugging and troubleshooting

Heap dump compare retained size/dominator/reference paths; LeakCanary; allocation traces; Android Studio Memory Profiler; native/graphics categories; repeated screen visits and low-memory device tests. Validate plateau after fix.

## 12. Comparison with related components and APIs

| Technique | Guidance |
|---|---|
| Strong | owned reference; retains |
| Weak | non-owning; may be null |
| Soft | unpredictable; avoid cache strategy |
| LruCache | explicit bounded eviction |
| Pool | profile-first, bounded |
| Heap dump | retained paths/dominators |
| LeakCanary | lifecycle retention diagnosis |

ART GC framework/runtime; tools diagnose only.

## 13. Interview questions with detailed answers

### 1. How GC works

ART traces roots/reachable graph; unreachable objects reclaimable, timing nondeterministic and algorithm varies.

### 2. Strong versus Weak reference

Strong keeps reachable; Weak does not prevent collection and dereference can be null.

### 3. Soft reference cache?

Avoid soft refs for modern cache; use explicit bounded cache with eviction policy.

### 4. Define memory leak

Reachable object held beyond intended lifetime by ownership/reference path.

### 5. Activity leak path

Singleton/static/callback retains Activity or view after screen; remove listener, scope object, avoid UI context.

### 6. Application context

Application context has app lifetime; suitable for app APIs, not UI themed/window operations.

### 7. Fragment binding leak

Fragment may survive view teardown; binding retains old view tree. Null binding in onDestroyView.

### 8. Bitmap memory

Dimensions × bytes/pixel approximation plus overhead; backing may be native/graphics; downsample.

### 9. Managed versus native memory

Managed heap versus JNI/native, graphics, mapped allocations; total process memory can exceed Java heap.

### 10. OOM causes

Heap/native pressure, oversized allocations, fragmentation, retained objects, limits. Analyze cause; do not just catch.

### 11. LeakCanary

Watches expected-to-clear objects and reports retention paths; diagnostic tool, confirm genuine leak.

### 12. Dominator

Object dominating another is on every root path; retained subtree helps locate owner.

### 13. GC and jank

Allocation churn and GC CPU/latency can impact frames; profile hot path.

### 14. Why not pool everything?

Pooling complexity and retention; modern allocation often cheap. Only profile-driven bounded pools.

### 15. Debug memory growth

Heap dumps, retained paths, allocation profiler, LeakCanary, native/graphics metrics; repeat visits and verify plateau.

### 16. Memory pressure and process death

System may kill cached/background process. Durable data must be persisted; memory cache is reconstructable.

## 14. Challenging follow-up questions

- Bitmap memory outside Java heap?
- Allocation churn versus retained leak?
- Why weak cache may miss?
- Draw singleton→Activity leak chain.
- How memory pressure affects process priority and kill?

For deeper follow-ups, state the Android version/target assumptions, draw the state or object/transaction flow, explain the trade-off, and say how you would test or inspect the behavior.

## 15. Final concise interview answer

Android memory includes managed, native and graphics. ART GC reclaims unreachable objects but not retained leaks. I manage ownership, clear Fragment views, avoid Activity references in singletons, bound caches and downsample images. Heap dumps and LeakCanary reveal retained paths; process pressure and kill are expected conditions.

## Revision checklist

- [ ] Can explain the introduction in 60–90 seconds.
- [ ] Can redraw and narrate the diagram.
- [ ] Can explain internal behavior and distinguish framework from library behavior.
- [ ] Can walk through the Kotlin example and edge cases.
- [ ] Can answer the 15 questions and defend follow-up trade-offs.
- [ ] Can describe a debugging approach and the evidence/tool needed.

---

*Platform behavior may vary by Android release, target SDK, device/OEM and runtime context. Validate policy-specific behavior against the interview scenario.*
