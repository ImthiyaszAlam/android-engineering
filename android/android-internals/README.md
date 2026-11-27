# Android Internals — Interview Preparation

## Purpose
An interview-answer repository focused on how Android framework components, AndroidX libraries, process/thread behavior, navigation, IPC, and memory work internally. Each topic is written in candidate voice and includes architecture, execution flow, diagrams, Kotlin, practical cases, pitfalls, edge cases, performance, troubleshooting, comparisons, and Q&A.

## Target level
Android Developer with 3–5 years of experience preparing for product-based companies. Answers emphasize reasoning, trade-offs, platform behavior, and production debugging—not API memorization.

## Topics
1. [Activity & Fragment Lifecycle](01-activity-fragment-lifecycle/README.md)
2. [ViewModel Internals](02-viewmodel-internals/README.md)
3. [Process Death & App Lifecycle](03-process-death-app-lifecycle/README.md)
4. [Services](04-services/README.md)
5. [Handler, Looper & MessageQueue](05-handler-looper-messagequeue/README.md)
6. [ANR & Main Thread Internals](06-anr-main-thread/README.md)
7. [Activity Launch Modes & Task Stack](07-activity-launch-modes-task-stack/README.md)
8. [BroadcastReceiver & ContentProvider](08-broadcastreceiver-contentprovider/README.md)
9. [Binder & Android IPC](09-binder-android-ipc/README.md)
10. [Android Memory Management](10-memory-management/README.md)

## Recommended learning order
Lifecycle → ViewModel → Process death → Handler/Looper → ANR → Services → Task stack/launch modes → Receiver/Provider → Binder/IPC → Memory. This order builds from component ownership to concurrency, background work, system communication, and resource pressure.

## Interview preparation routine
For each folder: (1) deliver the introduction aloud in 60–90 seconds; (2) redraw diagrams from memory; (3) narrate execution flow and callback ordering; (4) type and explain the Kotlin example; (5) answer all Q&A aloud; (6) tackle follow-ups by stating assumptions, trade-offs, and verification; (7) reproduce one scenario in a sample app; (8) finish with the concise answer.

## Version-awareness
Background execution, receiver registration, foreground services, task management, process reclamation, and API restrictions depend on Android version, target SDK, device, and OEM. Validate policy-specific claims for the interview's stated environment. These notes distinguish framework behavior from AndroidX behavior and avoid treating implementation details as timeless guarantees.
