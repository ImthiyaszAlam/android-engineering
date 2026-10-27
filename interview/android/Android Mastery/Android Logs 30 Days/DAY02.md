# FocusMate – Day 2

## Goal
- Add DataStore to save and retrieve simple user preferences (e.g., onboarding completed)
- Understand the difference between Room and DataStore
- Clean up folder structure to match clean architecture
- Build confidence with beginner-level explanations and Flow usage

---

## What You Built

```kotlin
val onboardingFlow: Flow<Boolean> = context.dataStore.data
    .map { preferences -> preferences[ONBOARDING_KEY] ?: false }
```

### Explained Word by Word

| Keyword                        | Meaning |
|-------------------------------|---------|
| `val`                         | Read-only variable |
| `onboardingFlow`              | Variable name for stream |
| `Flow<Boolean>`               | Stream that emits true/false values |
| `context.dataStore.data`      | Access the stored user preferences |
| `.map { preferences -> }`     | Transform preferences into a boolean |
| `preferences[ONBOARDING_KEY]` | Get the value for a specific key |
| `?: false`                    | Use false if the value is not set (default) |

---

## Visual Flow Diagram

```
[ DataStore Preferences ]
        ↓
  Flow<Preferences>  ← values change over time
        ↓  (map)
  Flow<Boolean> ← true or false
        ↓
 Used in ViewModel/UI to reactively show onboarding state
```

---

## Folder Structure (After Day 2)

```
FocusMate/
├── data/
│   ├── local/                   → Room database files
│   ├── prefs/                   → DataStore logic
│   │   └── PreferenceManager.kt
│
├── repository/
│   └── HabitRepository.kt       → DB abstraction
│
├── viewmodel/
│   └── HabitViewModel.kt        → Exposes data to UI
│
├── ui/
│   ├── MainActivity.kt          → UI using XML
│   └── SplashActivity.kt        → (Optional: navigation based on prefs)
│
├── di/
│   └── ServiceLocator.kt        → Temporary manual dependency injection
```

---

## Beginner Interview Q&A

### What is DataStore used for in Android?

**Answer:**  
DataStore is used to store small pieces of persistent data, like:
- Whether user completed onboarding
- Theme (dark/light)
- Username or login status

---

### What is the difference between Room and DataStore?

| Feature         | Room                        | DataStore                        |
|----------------|-----------------------------|----------------------------------|
| Use-case       | Store complex data lists     | Store settings/preferences       |
| Structure      | Tables, SQL, multiple rows   | Key-value pairs                  |
| Best for       | Notes, habits, expenses      | Theme, onboarding, toggles       |
| APIs used      | DAO, Entity, DB              | Preferences + Flow               |

---

### Why do we use Flow with DataStore?

**Answer:**  
Because DataStore is asynchronous and changes over time.  
Flow helps you:
- Get real-time updates
- Work in coroutines
- Reactively update your UI

---

### Can you store a list of habits in DataStore?

**Answer:**  
No.  
DataStore is for small, simple key-values only.  
Use Room for storing lists or tables of data.

---

## Tasks Completed Today

- [x] Set up DataStore
- [x] Saved onboarding status as Boolean
- [x] Observed onboarding Flow in MainActivity
- [x] Cleaned folder structure
- [x] Understood every word in the Flow line
- [x] Answered beginner-level questions


---

"Don’t just build features. Build clarity."
