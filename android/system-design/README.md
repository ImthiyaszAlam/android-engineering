# Android System Design

A practical collection of Android system design problems for developers preparing for mid-level Android engineering interviews (3–5 years of experience).

The goal is to build a repeatable approach to designing reliable, maintainable, performant, and scalable Android applications.

## 🎯 Learning Objectives

- Design scalable Android application architectures.
- Understand data flow and state management.
- Handle offline-first applications and synchronization.
- Design reliable background processing.
- Optimize application performance and memory usage.
- Understand concurrency, networking, and caching.
- Make informed architectural decisions and explain trade-offs.

## 📚 System Design Problems

| # | Problem | Key Topics | Status |
|---|---|---|---|
| 01 | [Instagram Feed](./01-instagram-feed/) | Pagination, caching, image loading, prefetching, infinite scrolling | ⬜ Not started |
| 02 | [WhatsApp Chat](./02-whatsapp-chat/) | WebSocket, real-time messaging, Room, FCM, delivery status | ⬜ Not started |
| 03 | [Offline-First Notes](./03-offline-first-notes/) | Room, offline writes, synchronization, conflict resolution | ⬜ Not started |
| 04 | [E-commerce App](./04-ecommerce-app/) | Product listing, search, filters, cart, pagination, payments | ⬜ Not started |
| 05 | [Uber / Ride Booking](./05-uber-ride-booking/) | Location tracking, Maps, WebSocket, foreground services | ⬜ Not started |
| 06 | [File Upload / Download Manager](./06-file-upload-download/) | WorkManager, resumable uploads, retries, network constraints | ⬜ Not started |
| 07 | [YouTube / Video Streaming](./07-youtube-streaming/) | Media3, adaptive streaming, buffering, background playback | ⬜ Not started |
| 08 | [Push Notification System](./08-push-notification-system/) | FCM, notification channels, deep links, background restrictions | ⬜ Not started |
| 09 | [News Feed](./09-news-feed/) | API integration, pagination, caching, refresh strategies | ⬜ Not started |
| 10 | [Music Streaming](./10-music-streaming/) | Media3, MediaSessionService, audio focus, caching | ⬜ Not started |

## 🎯 System Design Evaluation Checklist

Every problem should be approached using the following engineering dimensions.

| # | Area | What to Cover |
|---|---|---|
| 01 | Requirements | Functional and Non-Functional Requirements |
| 02 | Architecture | MVVM, Clean Architecture, Repository Pattern, Modularization |
| 03 | Data Flow | UI → ViewModel → UseCase → Repository → Data Sources |
| 04 | Networking | Retrofit, OkHttp, API Design, Pagination, Error Handling |
| 05 | Offline Support | Room, Caching, Data Synchronization, Conflict Resolution |
| 06 | Concurrency | Coroutines, Flow, Structured Concurrency, Thread Safety |
| 07 | Background Execution | WorkManager, JobScheduler, Foreground Services |
| 08 | Performance | Memory Management, Recomposition, Lazy Loading, Image Optimization |
| 09 | Scalability & Reliability | Large Datasets, Network Failures, Retry Strategies, Fault Tolerance |
| 10 | Testing | Unit Tests, Integration Tests, UI Tests |

### Interviewer's Perspective

For every design decision, be prepared to answer:

- Why did you choose this approach?
- What alternatives did you consider?
- What happens when something fails?
- How does the design behave under poor network conditions?
- How will it perform with millions of users?
- How would you test this implementation?
- What are the limitations and trade-offs?

## 🧠 Core Android Areas to Master

- Android Architecture & Modularization
- Jetpack Compose Internals
- Kotlin Coroutines & Flow
- Networking & API Design
- Room & Data Persistence
- WorkManager & JobScheduler
- Services & Background Execution
- Caching & Offline Synchronization
- Performance Optimization
- Testing & Debugging

## 📈 Progress Tracker

Update this section as you complete each problem.

- Problems completed: 0/10
- Architecture diagrams completed: 0/10
- Deep dives completed: 0/10
- Interview practice completed: 0/10

## 📝 How to Use This Repository

1. Start with the problem statement in each folder.
2. Write functional and non-functional requirements.
3. Design the architecture before choosing libraries.
4. Document data flow, APIs, persistence, and background work.
5. Explore failure scenarios and edge cases.
6. Explain alternatives and architectural trade-offs.
7. Add diagrams and testing strategy.
8. Practice answering follow-up questions aloud.

Each problem folder uses the same template so the preparation remains consistent.

---

**Target:** Android Developer | 3–5 Years Experience  
**Focus:** Practical engineering decisions over theoretical answers.
