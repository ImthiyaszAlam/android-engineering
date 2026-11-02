# Day 01 – To-Do App with Clean Architecture

## What I Learned

* MVVM vs Clean Architecture
* Why layers matter: UI ↔ Domain ↔ Data
* How to design scalable interfaces

---

## Architecture Diagram

```
UI Layer:            TaskListScreen.kt / AddTaskScreen.kt  
        ↓  
Presentation Layer:  TaskViewModel.kt  
        ↓  
Domain Layer:        AddTaskUseCase.kt / GetAllTasksUseCase.kt  
        ↓  
Repository Layer:    TaskRepository.kt (interface) / TaskRepositoryImpl.kt  
        ↓  
Data Layer:          Room DAO  
```

---

## Interview Questions Answered

### 1. What if Room insert fails?

* Wrap the operation inside `Result<T>` to handle success/failure
* Log errors using Crashlytics or Logcat
* Show a user-friendly message using a Snackbar or Toast

---

### 2. How would you modularize this To-Do app for a team of 5?

* Create separate modules such as:

  * `:feature:task` — Task screens and ViewModel
  * `:core:domain` — UseCases and domain models
  * `:core:data` — DAO, Room, and repository implementations
  * `:core:ui` — Common UI components and themes

This allows the team to work independently and parallelly.

---

### 3. Why use UseCase instead of calling repository directly?

* Keeps ViewModel focused on UI logic only
* Business logic becomes reusable in other layers (e.g., WorkManager, tests)
* Enhances testability and separation of concerns

---

## Interfaces

```kotlin
// TaskRepository.kt
interface TaskRepository {
    suspend fun addTask(task: Task): Result<Unit>
    suspend fun getAllTasks(): Result<List<Task>>
}
```

---

## Simplified Revision Notes

### 1. What if Room insert fails?

**Possible issues:**

* SQLiteExceptions
* Database corruption
* Incorrect input formats

**What to do:**

* Wrap database calls with `Result<T>` to catch errors
* Log exceptions for tracking and analytics
* Show user feedback without crashing the app

---

### 2. How would you modularize this To-Do app?

**Why modularize:**

* Teams work independently
* Code becomes scalable and maintainable

**Suggested module structure:**

| Module          | Responsibility                   |
| --------------- | -------------------------------- |
| `:feature:task` | Screens, ViewModels              |
| `:core:domain`  | UseCases, business logic, models |
| `:core:data`    | DAOs, Room DB, RepositoryImpl    |
| `:core:ui`      | Common buttons, themes, styles   |

---

### 3. Why use UseCase over direct repository calls?

**Benefits:**

* Keeps ViewModel thin and focused
* Encourages reuse of logic
* Ideal for background tasks and testing

**UseCase is like a focused command:**

* "Add a task to DB"
* "Get all tasks from DB"

This makes code more modular and decoupled.

---

## TL;DR for Revision

| Question                    | Answer                                                                   |
| --------------------------- | ------------------------------------------------------------------------ |
| What if Room insert fails?  | Use `Result<T>`, log the error, show a Snackbar or Toast                 |
| How to modularize for team? | Create modules like `:feature`, `:core:data`, `:core:domain`, `:core:ui` |
| Why use UseCase?            | ViewModel stays clean, logic becomes reusable and easier to test         |

