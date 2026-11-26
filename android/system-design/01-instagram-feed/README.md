
# System Design: Instagram Feed

**Level:** Mid-Level Android Engineer (3–5 Years)  
**Difficulty:** Advanced  
**Focus:** Android Architecture, Networking, Pagination, Offline-First, Performance, Concurrency

---

# 1. Problem Understanding

## Problem Statement

Design an Instagram-like Android application that allows users to browse a personalized feed containing posts from users they follow.

Each post can contain images, videos, captions, likes, comments, and user information.

The application must provide a smooth scrolling experience, efficiently load large datasets, support unreliable network conditions, and minimize unnecessary network and resource consumption.

### Scope

For this design, I will focus primarily on the Android client architecture and its interaction with backend services.

The backend is responsible for generating personalized feeds, managing social relationships, storing posts, and processing user interactions.

The Android application is responsible for rendering the feed efficiently, managing UI state, caching data, handling network requests, and providing a reliable user experience.

### Core Features

1. Display a personalized feed.
2. Support infinite scrolling.
3. Like and unlike posts.
4. Display images and videos.
5. Open post details and comments.
6. Pull-to-refresh.
7. Support cached feed data.
8. Handle network failures gracefully.

### Out of Scope

- Creating posts.
- Stories and reels.
- Direct messaging.
- Advertising and recommendation algorithms.
- Backend infrastructure implementation.

---

# 2. Requirements

## 2.1 Functional Requirements

| Requirement | Description |
|---|---|
| Feed Loading | Fetch personalized posts from the server. |
| Infinite Scrolling | Load additional posts as the user scrolls. |
| Post Interaction | Like and unlike posts. |
| Media Loading | Display images and video thumbnails. |
| Post Details | Display complete post information. |
| Comments | Fetch comments for individual posts. |
| Refresh | Fetch the latest feed data. |
| Offline Support | Display previously cached posts. |

## 2.2 Non-Functional Requirements

| Requirement | Design Consideration |
|---|---|
| Performance | Smooth scrolling and efficient rendering. |
| Reliability | Graceful handling of network failures. |
| Scalability | Support large feeds without loading everything into memory. |
| Responsiveness | Display cached content immediately when available. |
| Battery Efficiency | Avoid unnecessary background requests. |
| Memory Efficiency | Load media lazily and release unused resources. |
| Consistency | Prevent stale data and duplicate interactions. |
| Security | Secure authentication and user data. |

## 2.3 Important Assumptions

- The user is already authenticated.
- Feed generation happens on the backend.
- The backend supports cursor-based pagination.
- Each post has a unique identifier.
- The feed is sorted by a server-defined ranking strategy.
- Media files are delivered through a CDN.

---

# 3. High-Level Architecture

## 3.1 Architecture Decision

I would choose:

- MVVM for presentation logic.
- Clean Architecture boundaries for separation of concerns.
- Repository Pattern for data abstraction.
- Jetpack Compose for UI.
- Kotlin Coroutines and StateFlow for asynchronous operations.
- Retrofit and OkHttp for networking.
- Room for local persistence.
- Paging 3 for pagination.
- Coil for image loading.

I would avoid introducing unnecessary abstraction layers unless the application complexity justifies them.

## 3.2 Overall Architecture Diagram

```text
                 ANDROID APPLICATION
                         |
                         |
              +---------------------+
              |  Presentation Layer |
              |                     |
              |  FeedScreen         |
              |  FeedViewModel      |
              |  FeedUiState        |
              +---------------------+
                         |
                         v
              +---------------------+
              |    Domain Layer     |
              |                     |
              |  GetFeedUseCase     |
              |  LikePostUseCase    |
              |  Post Entity        |
              +---------------------+
                         |
                         v
              +---------------------+
              |     Data Layer      |
              |                     |
              |  FeedRepository     |
              +---------------------+
                    /         \
                   /           \
                  v             v
          +-------------+  +-------------+
          | Remote Data |  | Local Data  |
          | Source      |  | Source      |
          +-------------+  +-------------+
                 |              |
                 v              v
             Retrofit         Room
                 |              |
                 v              v
           Backend API      Local DB
                 |
                 v
                CDN
                 |
                 v
            Images/Video
```

## 3.3 Layer Responsibilities

### Presentation Layer

Responsible for displaying the feed and handling user interactions.

Components:
- FeedScreen
- PostItem
- FeedViewModel
- FeedUiState

The ViewModel exposes observable UI state through StateFlow.

The Composable observes this state and renders the UI.

### Domain Layer

Contains business rules independent of Android frameworks.

Components:
- GetFeedUseCase
- LikePostUseCase
- UnlikePostUseCase
- Post
- User

For a small application, I would not create a separate UseCase for every repository method. I would introduce use cases where they represent meaningful business operations or coordinate multiple dependencies.

### Data Layer

Responsible for retrieving and persisting data.

Components:
- FeedRepository
- FeedRemoteDataSource
- FeedLocalDataSource
- FeedApiService
- FeedDao

The repository decides how remote and local data are combined.

---

# 4. Detailed Data Flow

## 4.1 Initial Feed Loading

When a user opens the application:

```text
User Opens Feed
       |
       v
FeedScreen
       |
       v
FeedViewModel
       |
       v
GetFeedUseCase
       |
       v
FeedRepository
       |
       +----------------------+
       |                      |
       v                      v
    Room DB               Feed API
       |                      |
       v                      v
Cached Posts             Latest Posts
       |                      |
       |                      v
       |                 Save to Room
       |                      |
       +----------+-----------+
                  |
                  v
              StateFlow
                  |
                  v
             FeedScreen
                  |
                  v
             Render Posts
```

### Explanation

1. The user opens the feed screen.
2. The ViewModel initiates feed loading.
3. The repository exposes cached data from Room.
4. The UI displays available cached posts.
5. The repository requests the latest feed from the backend.
6. The response is mapped into local database entities.
7. Room is updated inside a transaction.
8. The observable database query emits the latest data.
9. StateFlow propagates the updated state to the UI.
10. Compose recomposes the affected UI.

This approach gives us a single source of truth: the local database.

The UI does not need to decide whether data came from the network or local storage.

---

# 5. Pagination Strategy

## 5.1 Problem

An Instagram feed can contain thousands of posts.

Fetching everything in one API request would cause:

- High network consumption.
- Increased memory usage.
- Slow initial loading.
- Unnecessary processing.
- Poor scrolling performance.

Therefore, I would use pagination.

## 5.2 Offset vs Cursor-Based Pagination

### Offset-Based Pagination

Example:

```http
GET /feed?page=1&limit=20
GET /feed?page=2&limit=20
GET /feed?page=3&limit=20
```

Problem:

Suppose the user loads page 1 and receives posts 1–20.

Before page 2 is requested, a new post is inserted at the beginning.

The next request may return posts 20–39.

Post 20 is duplicated.

Offset pagination can also skip items when records are inserted or removed.

### Cursor-Based Pagination

Instead of requesting a page number, the client sends a cursor representing where the previous request ended.

Example:

```http
GET /api/v1/feed?limit=20

GET /api/v1/feed?limit=20&cursor=abc123

GET /api/v1/feed?limit=20&cursor=xyz789
```

The backend returns:

```json
{
  "data": [
    {
      "id": "post_101",
      "caption": "Beautiful day",
      "image_url": "https://cdn.example.com/image.jpg",
      "likes_count": 120,
      "is_liked": false
    }
  ],
  "next_cursor": "abc123",
  "has_more": true
}
```

I would prefer cursor-based pagination because the feed is continuously changing.

The backend should generate cursors based on a stable ordering, such as a combination of ranking position, creation time, and unique post ID.

## 5.3 Android Implementation

I would use Paging 3.

Main components:

- PagingSource: Loads pages from the remote API.
- Pager: Creates the paging stream.
- PagingData: Represents paginated data.
- LazyPagingItems: Exposes paginated data to Compose.
- RemoteMediator: Coordinates remote pagination with Room when implementing a database-backed paging source.

### Paging Architecture

```text
             FeedScreen
                  |
                  v
             FeedViewModel
                  |
                  v
               Pager
                  |
                  v
             PagingSource
                  |
                  v
           FeedRepository
                  |
                  v
              Feed API
                  |
                  v
             PagingData
                  |
                  v
            LazyColumn
```

### Important Edge Cases

1. Prevent duplicate requests.
2. Handle expired cursors.
3. Stop loading when has_more is false.
4. Handle empty responses.
5. Handle network failures without losing existing posts.
6. Handle refresh while pagination is running.
7. Prevent duplicate posts using unique post IDs.
8. Preserve the user's scroll position when appropriate.

---

# 6. Database and Caching Strategy

## 6.1 Why Room?

I would use Room because:

- It provides structured local persistence.
- It supports observable queries through Flow.
- It integrates with Paging 3.
- It supports transactions.
- It allows the application to display cached data without network access.

## 6.2 Database Schema

### Posts Table

| Column | Type | Description |
|---|---|---|
| post_id | String | Primary key |
| user_id | String | Post owner |
| caption | String | Post caption |
| media_url | String | Media location |
| likes_count | Int | Number of likes |
| is_liked | Boolean | Current user's like state |
| created_at | Long | Creation timestamp |

### Users Table

| Column | Type | Description |
|---|---|---|
| user_id | String | Primary key |
| username | String | Username |
| profile_image | String | Profile image URL |

### Feed Keys Table

| Column | Type | Description |
|---|---|---|
| feed_id | String | Feed identifier |
| next_cursor | String | Next page cursor |

In a real implementation, I would also define the relationship between feed membership and posts. This matters because the same post can appear in different feed contexts.

## 6.3 Cache Strategy

I would use multiple caching layers.

```text
          Feed Data
              |
       +------+------+
       |             |
       v             v
    Room DB       Coil Cache
       |             |
       v             +----------------+
  Structured Data    |                |
                 Memory Cache      Disk Cache
```

Room stores structured post and user data.

Coil manages image loading and image caching.

I would not store large image bitmaps directly in Room.

### Cache Invalidation

The cache should not remain valid indefinitely.

I would maintain metadata such as:

- Last successful refresh time.
- Cached page cursor.
- Feed synchronization status.

When the user refreshes, the application requests newer data.

When cached data becomes stale, the application can display it while refreshing in the background.

The exact expiration policy should be based on product requirements rather than an arbitrary fixed duration.

---

# 7. Offline-First Strategy

## 7.1 Scenario

Suppose the user opens Instagram, loads 20 posts, and then loses internet connectivity.

The application should continue displaying those 20 posts.

I would use Room as the source of truth.

```text
              Feed UI
                 |
                 v
             Room Flow
                 |
                 v
             Feed UI

      Remote API <----> Repository
                           |
                           v
                        Room DB
```

The UI observes Room rather than maintaining separate copies of remote and local feed data.

## 7.2 What About Like/Unlike Operations?

Suppose the user likes a post while offline.

I would implement optimistic UI updates.

Flow:

```text
User Clicks Like
       |
       v
Update Local Like State
       |
       v
UI Shows Liked
       |
       v
Save Pending Operation
       |
       v
Network Available?
       |
    +--+--+
    |     |
   No    Yes
    |     |
    v     v
 Keep   Send API
 Pending   |
           v
       API Success?
        /      \
       Yes      No
        |        |
        v        v
      Remove   Retry or
      Pending  Reconcile
```

### Implementation Considerations

I would maintain a pending actions table containing:

- Operation ID.
- Post ID.
- Operation type.
- Creation timestamp.
- Retry count.
- Synchronization status.

When connectivity returns, pending operations can be synchronized.

I would use WorkManager for this type of deferrable synchronization, with appropriate network constraints.

I would not use WorkManager for immediate feed loading or every pagination request.

### Conflict Resolution

Suppose:

- Local state says liked.
- Server state says unliked.

The application needs a defined conflict policy.

For a like action, I would prefer an idempotent API that represents the desired final state rather than blindly incrementing or decrementing a counter.

The server remains authoritative for the final like count and user interaction state.

---

# 8. Concurrency and State Management

## 8.1 Kotlin Coroutines

I would use Kotlin Coroutines for asynchronous operations.

Responsibilities:

| Component | Responsibility |
|---|---|
| viewModelScope | ViewModel-related operations |
| Dispatchers.IO | Network and database operations |
| Dispatchers.Default | CPU-intensive processing |
| Flow | Observe database changes |
| StateFlow | Expose UI state |

I would avoid manually creating unmanaged threads.

## 8.2 UI State

For a regular screen, I would define a state model such as:

```kotlin
data class FeedUiState(
    val isRefreshing: Boolean = false,
    val error: String? = null
)
```

For paginated data, I would use Paging 3's LoadState for:

- Initial loading.
- Append loading.
- Refresh errors.
- Append errors.
- Empty results.

This avoids duplicating pagination state unnecessarily.

## 8.3 Preventing Race Conditions

Consider the following situation:

The user clicks Like five times rapidly.

Without proper handling, multiple requests could be sent and produce inconsistent results.

I would:

1. Disable or debounce repeated interactions where appropriate.
2. Update the desired local state immediately.
3. Use an idempotent backend endpoint.
4. Track pending operations.
5. Reconcile the result with the server response.

For concurrent feed requests, Paging 3 manages much of the paging lifecycle, but the repository and data layer must still handle cursor consistency and database transactions correctly.

---

# 9. Performance Optimization

Performance is critical because the feed contains media and potentially thousands of posts.

## 9.1 Jetpack Compose Optimization

I would use LazyColumn rather than Column with a large list.

Reasons:

- Only visible items and required prefetched items are composed.
- Reduces unnecessary UI work.
- Supports large datasets.

Example:

```kotlin
LazyColumn {
    items(
        count = posts.itemCount,
        key = posts.itemKey { it.id }
    ) { index ->

        val post = posts[index]

        if (post != null) {
            PostItem(post = post)
        }
    }
}
```

I would also:

- Use stable keys.
- Avoid expensive calculations inside composables.
- Keep UI state immutable.
- Avoid unnecessary state reads.
- Use appropriate remember and derivedStateOf.
- Avoid passing frequently changing state to unrelated components.

## 9.2 Image Loading Optimization

I would use Coil.

Strategies:

1. Load thumbnail-sized images in the feed.
2. Load full-resolution images on the detail screen.
3. Use memory and disk caching.
4. Avoid loading every image simultaneously.
5. Prefetch images near the viewport when beneficial.
6. Use appropriate image dimensions and transformations.

The backend should provide optimized image variants instead of forcing the client to download unnecessarily large original images.

## 9.3 Video Optimization

For video posts:

- Use AndroidX Media3.
- Avoid playing every visible video simultaneously.
- Autoplay only the selected visible item.
- Pause playback when the item is no longer visible.
- Release unnecessary player resources.
- Consider preloading the next video when beneficial.

## 9.4 Memory Management

I would monitor:

- Bitmap memory usage.
- Player lifecycle.
- Activity and ViewModel references.
- Long-lived coroutine scopes.
- Excessive retained UI state.

I would use Android Studio Profiler and LeakCanary to investigate memory issues.

---

# 10. Background Execution

An important interview distinction is choosing the correct Android background execution API.

| Requirement | Suitable Approach |
|---|---|
| Load feed while screen is visible | Coroutines |
| Fetch next page | Paging 3 |
| Synchronize pending likes | WorkManager |
| Periodic deferrable refresh | WorkManager |
| Continuous user-visible media playback | MediaSessionService / Foreground Service when required |

I would not introduce a foreground service merely to refresh a feed.

Android background execution restrictions must be respected.

---

# 11. Networking and Error Handling

I would use Retrofit with OkHttp.

The network layer should handle:

- Connection failures.
- Request timeouts.
- HTTP 401 and token expiration.
- HTTP 403 authorization failures.
- HTTP 404 missing resources.
- HTTP 429 rate limiting.
- HTTP 500 server errors.
- Malformed responses.

### Retry Strategy

I would not retry every request blindly.

For transient failures, use bounded retries with exponential backoff and jitter.

For non-idempotent operations, retries must be designed carefully to avoid duplicate actions.

For authentication failures, the authentication layer should handle token refresh safely without creating infinite retry loops.

### Error Presentation

| Error | UI Behavior |
|---|---|
| No internet | Show cached feed and offline indicator |
| Initial request failure | Show retry screen |
| Pagination failure | Show retry option at bottom |
| Image failure | Show placeholder |
| Session expired | Handle authentication flow |
| Rate limited | Respect server retry instructions |

---

# 12. API Design

I would expect the backend to expose APIs similar to:

| Method | Endpoint | Purpose |
|---|---|---|
| GET | /api/v1/feed | Fetch personalized feed |
| GET | /api/v1/posts/{id} | Fetch post details |
| PUT | /api/v1/posts/{id}/like | Set desired like state |
| GET | /api/v1/posts/{id}/comments | Fetch comments |
| GET | /api/v1/users/{id} | Fetch profile |

Example feed request:

```http
GET /api/v1/feed?limit=20&cursor=abc123
Authorization: Bearer <token>
```

Example like request:

```http
PUT /api/v1/posts/post_101/like

{
    "liked": true
}
```

Example response:

```json
{
    "post_id": "post_101",
    "is_liked": true,
    "likes_count": 121
}
```

Using desired state makes repeated requests easier to handle idempotently.

The backend should enforce authorization and return authoritative interaction state.

---

# 13. Security Considerations

- Store authentication tokens using secure storage.
- Use HTTPS.
- Never hardcode secrets in the Android application.
- Avoid logging access tokens or sensitive user data.
- Validate authorization on the server.
- Handle expired authentication sessions.
- Avoid exposing private posts to unauthorized users.

The client must never be treated as the authority for access control.

---

# 14. Testing Strategy

## 14.1 Unit Testing

I would test:

- FeedViewModel state transitions.
- Repository behavior.
- Pagination logic.
- Like/unlike operations.
- Error handling.
- Pending action synchronization.

## 14.2 Integration Testing

I would test:

- Retrofit API integration.
- Room DAO operations.
- PagingSource behavior.
- RemoteMediator synchronization.
- Cache invalidation.
- Database transactions.

## 14.3 UI Testing

I would test:

- Feed rendering.
- Infinite scrolling.
- Pull-to-refresh.
- Like/unlike interactions.
- Loading and error states.
- Empty feed state.
- Offline behavior.

## 14.4 Performance Testing

I would measure:

- Cold and warm feed startup.
- Frame rendering and jank.
- Image loading latency.
- Memory consumption during long scrolling sessions.
- Network request frequency.
- Battery consumption.

---

# 15. Failure Scenarios and Edge Cases

| Scenario | Solution |
|---|---|
| Internet unavailable | Display cached feed |
| API timeout | Bounded retry |
| Empty feed | Display empty state |
| Duplicate posts | Deduplicate using post ID |
| Expired cursor | Reset pagination |
| Rapid scrolling | Controlled loading and prefetching |
| Repeated like requests | Idempotent API and operation tracking |
| Process death | Restore appropriate UI state and reload persisted data |
| Image loading failure | Placeholder and retry |
| Token expiration | Safe token refresh |
| Server returns stale data | Apply server version/timestamp policy |
| User refreshes during pagination | Coordinate refresh and invalidate old paging generation |
| App goes into background | Cancel unnecessary screen-scoped operations |
| Very large images | Load optimized variants |

---

# 16. Architectural Trade-offs

A strong design requires understanding why one solution is better than another in a particular situation.

| Decision | Chosen Approach | Alternative | Reason |
|---|---|---|---|
| UI | Jetpack Compose | XML | Declarative UI and state-driven rendering |
| Architecture | MVVM | MVC | Separation of UI and presentation logic |
| Networking | Retrofit | Ktor | Mature Android networking ecosystem |
| Database | Room | Direct SQLite | Structured persistence and Flow integration |
| Pagination | Paging 3 | Manual pagination | Lifecycle-aware paging infrastructure |
| Pagination Strategy | Cursor | Offset | Better behavior for changing feeds |
| Image Loading | Coil | Manual Bitmap Loading | Caching and lifecycle integration |
| UI State | StateFlow | LiveData | Kotlin Flow integration |
| Background Sync | WorkManager | Custom Service | Deferrable reliable work |

### Important Trade-off: Room vs Direct Network Paging

If the application does not require offline support, a simpler PagingSource backed directly by the API can be sufficient.

If the application requires an offline-first experience, I would use Room with RemoteMediator.

I would not introduce RemoteMediator without a genuine need for database-backed pagination.

---

# 17. Interview Follow-up Questions and Answers

## Q1. Why would you use MVVM instead of MVC?

MVVM separates presentation logic from UI rendering.

The ViewModel owns screen state and survives configuration changes.

This makes the application easier to test and reduces tight coupling between UI and business logic.

## Q2. Why cursor-based pagination instead of offset-based pagination?

A feed changes continuously as new posts are created.

Offset pagination can produce duplicates or skip records when data changes between requests.

Cursor pagination provides a more stable continuation mechanism when the backend uses a consistent ordering.

## Q3. How does Paging 3 work?

Paging 3 provides a structured way to load large datasets incrementally.

The PagingSource loads data in pages, Pager creates a Flow of PagingData, and LazyPagingItems exposes the data to Compose.

When using Room with RemoteMediator, the mediator fetches remote pages and stores them locally. The UI observes the database-backed PagingSource.

## Q4. Why use Room if we already have an API?

Room provides local persistence.

It allows the application to display previously fetched content without waiting for network requests.

It also provides a source of truth for offline-first data synchronization.

## Q5. How would you prevent duplicate API calls?

I would use Paging 3 for pagination lifecycle management, ensure cursor consistency, and avoid launching independent duplicate requests for the same operation.

At the data layer, I would also enforce deduplication using unique identifiers.

## Q6. How would you handle optimistic updates?

I would update the local database immediately so the UI reflects the user's action.

Then I would send the request to the backend.

If the request fails, I would either retry or reconcile the local state based on the operation and server response.

## Q7. What happens if the user scrolls very quickly?

LazyColumn composes visible and prefetched content rather than the entire feed.

Paging 3 can load additional pages based on prefetch distance.

I would also ensure image requests are efficiently managed and unnecessary media work is cancelled.

## Q8. How would you handle process death?

The ViewModel alone is not a permanent storage mechanism.

I would persist feed data in Room and preserve essential screen state using SavedStateHandle where appropriate.

When the application is recreated, it can reconstruct the feed from persistent data and refresh from the server.

## Q9. Would you use WorkManager for feed pagination?

No.

Pagination is user-driven and should happen through coroutines and Paging 3 while the screen is active.

WorkManager is appropriate for deferrable background work such as synchronizing pending offline actions.

## Q10. How would you scale this application to millions of users?

From the Android side, I would focus on:

- Efficient pagination.
- Local caching.
- Optimized media loading.
- Controlled network requests.
- Memory-efficient rendering.
- Reliable error handling.

The backend would need personalized feed generation, caching, database optimization, CDN delivery, and horizontally scalable services.

The mobile application should not attempt to download or process the entire social graph.

---

# 18. Final Interview Summary

If I had to summarize my design in an interview:

"I would build the Android application using MVVM with clear separation between presentation, domain, and data layers.

For the feed, I would use Paging 3 with cursor-based pagination to efficiently load posts.

For offline support, I would use Room as the source of truth and Retrofit for remote communication. If database-backed pagination is required, I would integrate RemoteMediator.

I would use Coil for image loading and caching, Jetpack Compose with LazyColumn for efficient rendering, and Kotlin Coroutines and StateFlow for asynchronous operations and state management.

For user interactions such as liking posts, I would implement optimistic updates with an idempotent backend API and maintain pending operations when offline.

I would use WorkManager only for deferrable background synchronization, not for normal screen-driven network requests.

Finally, I would focus on handling pagination races, stale data, process death, network failures, memory consumption, and unnecessary recompositions."

---

# 19. Completion Checklist

| Area | Status |
|---|---|
| Requirements | Not Reviewed |
| High-Level Architecture | Not Reviewed |
| Component-Level Design | Not Reviewed |
| Data Flow | Not Reviewed |
| API Design | Not Reviewed |
| Pagination | Not Reviewed |
| Database and Caching | Not Reviewed |
| Offline Synchronization | Not Reviewed |
| Concurrency | Not Reviewed |
| Background Execution | Not Reviewed |
| Performance | Not Reviewed |
| Failure Scenarios | Not Reviewed |
| Security | Not Reviewed |
| Testing | Not Reviewed |
| Trade-offs | Not Reviewed |
| Interview Follow-ups | Not Reviewed |

**Revision Goal:** Be able to independently explain the complete design, defend architectural decisions, draw the architecture from memory, and answer follow-up questions without relying on notes.

**Last Revised:** Not started
