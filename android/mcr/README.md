# Android Machine Coding Preparation

Practical Android interview exercises using Kotlin and Jetpack Compose.

## Problem index

| # | Problem | Main focus |
|---|---|---|
| 1 | [Product Listing App](./01-product-listing/README.md) | Compose, Retrofit, MVVM, StateFlow, Coil |
| 2 | [E-commerce Cart](./02-ecommerce-cart/README.md) | Compose, ViewModel, state management, Room (optional) |
| 3 | [Debounced Search](./03-debounced-search/README.md) | StateFlow, debounce, distinctUntilChanged, flatMapLatest, Retrofit |
| 4 | [Paginated Feed](./04-paginated-feed/README.md) | Paging 3, PagingSource, RemoteMediator, Room, LazyColumn |
| 5 | [Offline-First Notes](./05-offline-notes/README.md) | Room, Flow, Repository, WorkManager |
| 6 | [Chat Application](./06-chat-app/README.md) | WebSocket, REST, Room, StateFlow, LazyColumn |
| 7 | [OTP Verification](./07-otp-verification/README.md) | Compose input/focus, ViewModel, coroutine countdown, autofill |
| 8 | [Expense Tracker](./08-expense-tracker/README.md) | Room, Flow, Compose, date filtering, aggregation |
| 9 | [Image Gallery](./09-image-gallery/README.md) | LazyVerticalGrid, Coil, MediaStore, caching |
| 10 | [File Download Manager](./10-download-manager/README.md) | DownloadManager or foreground service, WorkManager where appropriate, persistence |

## Recommended preparation order

1. Product Listing
2. E-commerce Cart
3. Debounced Search
4. Paginated Feed
5. Offline-First Notes
6. Chat Application
7. OTP Verification
8. Expense Tracker
9. Image Gallery
10. Download Manager

## What interviewers evaluate

- Correctness and edge-case handling
- Compose UI quality and reusable components
- Kotlin, coroutines, Flow, and structured concurrency
- State ownership and lifecycle awareness
- API integration and local persistence where needed
- Performance, stable list keys, and image loading
- Testability and code clarity
- Ability to explain alternatives and trade-offs

## Suggested time-box

- 5 min: clarify requirements and sketch UI
- 5 min: define models, UI state, and data flow
- 25–35 min: implement the core flow
- 10 min: handle errors and edge cases
- 5–10 min: test, clean up, and explain decisions

## Default stack

Kotlin, Jetpack Compose + Material 3, ViewModel, StateFlow, Coroutines, Retrofit/OkHttp, Room when persistence is needed, Coil for images, and JUnit. Use Hilt when requested or when dependency injection is part of the exercise.

**Rule:** Build the simplest design that meets the requirements. Do not over-engineer before the main flow works.
