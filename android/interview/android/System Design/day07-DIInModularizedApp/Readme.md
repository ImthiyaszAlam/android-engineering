
# 🚀 Day 7 – Hilt DI in Modularized Android Projects

# 

This document covers today's learning about **Hilt Dependency Injection (DI)** in a modularized Android project and provides answers to common interview questions.

---

## **Today's Learning**

### **1. Why Hilt in Modularized Projects?**

* Hilt provides a structured, compile-time dependency injection system built on top of Dagger.
* In a multi-module project, Hilt helps manage dependencies across `core` and `feature` modules without introducing circular dependencies.
* It provides a standardized way to share global dependencies like Retrofit, Room, or Repository classes.

### **2. Key Concepts Recap**

* **`@HiltAndroidApp`**: Bootstraps Hilt in the `Application` class.
* **Components**: Predefined scopes like `SingletonComponent`, `ActivityRetainedComponent`, `ViewModelComponent`.
* **`@Module` and `@InstallIn`**: Define and install dependency providers.
* **Scopes**: Control the lifecycle of dependencies (e.g., `@Singleton`, `@ViewModelScoped`).
* **Core Modules**: Contain shared dependencies like network, database, logging.
* **Feature Modules**: Contain UI and feature-specific logic.

### **3. System Design Overview for Modular Hilt**

* **App Module**: Minimal, contains `@HiltAndroidApp` and stitches dependencies.
* **Core Modules**: Provide global dependencies.
* **Feature Modules**: Consume dependencies via `@AndroidEntryPoint`.
* **No Cross-Feature Dependency**: Use core modules as the shared layer.

---

## **Textual Architecture Diagram**

```
               +-------------------+
               |   Application     |
               |  @HiltAndroidApp  |
               +---------+---------+
                         |
                         v
              +-----------------------+
              |     App Module        |
              |  (Main Activity, Nav) |
              +-----------------------+
                         |
                         v
          +----------------------------+
          |        Core Modules        |
          |----------------------------|
          | core_network: Retrofit, OkHttp
          | core_database: Room, DAO
          | core_data: Repository Layer
          | core_utils: Logger, Helpers
          +----------------------------+
                         |
       ---------------------------------------
       |                  |                  |
       v                  v                  v
+---------------+   +---------------+   +---------------+
| Feature_Login |   | Feature_Home  |   | Feature_Profile|
|  @EntryPoint  |   |  @EntryPoint  |   |  @EntryPoint   |
+---------------+   +---------------+   +---------------+
       ^                  ^                  ^
       |                  |                  |
       +--------> Shared Dependencies <-------+
                  (Provided by Core)
```

---

## **Interview Questions and Answers**

### **1. What is Dependency Injection?**

Dependency Injection (DI) is a design pattern where dependencies are provided to a class instead of creating them internally. It improves testability, modularity, and reusability.

---

### **2. Why use Hilt over Dagger or Koin?**

* **Hilt vs Dagger**: Hilt reduces boilerplate and provides built-in Android integrations.
* **Hilt vs Koin**: Hilt is compile-time safe (Dagger-based), whereas Koin is runtime-based and slower for large apps.
* Hilt integrates seamlessly with ViewModels, WorkManager, and other Android components.

---

### **3. What are the benefits of DI in Android?**

* Centralized dependency management.
* Easier testing with mocks.
* Reduces coupling between classes.
* Improves code readability and scalability.

---

### **4. Explain the role of `@HiltAndroidApp`.**

`@HiltAndroidApp` triggers Hilt's code generation and sets up the dependency graph at the application level. It must be added to the `Application` class.

---

### **5. What is a `Component` in Hilt?**

A Component is a container for dependencies. Hilt provides predefined components like:

* `SingletonComponent` – app-wide dependencies.
* `ActivityRetainedComponent` – survives configuration changes.
* `ViewModelComponent` – scoped to a single ViewModel instance.

---

### **6. Difference between `@InstallIn(SingletonComponent::class)` and `@InstallIn(ViewModelComponent::class)`?**

* `SingletonComponent`: The dependency is created once for the entire app lifecycle.
* `ViewModelComponent`: The dependency exists as long as the ViewModel exists.

---

### **7. What are Hilt Scopes?**

Scopes define the lifecycle of a dependency.

* `@Singleton` – app-wide.
* `@ActivityScoped` – tied to the activity lifecycle.
* `@ViewModelScoped` – tied to a ViewModel.

---

### **8. How do you configure Hilt in a multi-module project?**

* Add Hilt dependencies to all required modules.
* Define `@Module` + `@InstallIn` in core modules.
* Use `@AndroidEntryPoint` in activities/fragments in feature modules.
* Share global dependencies via `core_*` modules.

---

### **9. How do you share dependencies (e.g., Retrofit, Room) across multiple feature modules?**

* Place them in a `core_network` or `core_data` module.
* Use `@Provides` or `@Binds` in a Hilt module annotated with `@InstallIn(SingletonComponent::class)`.
* Add the `core` module as a dependency to the feature modules.

---

### **10. What are common pitfalls when using Hilt with feature modules?**

* Forgetting `@AndroidEntryPoint`.
* Defining the same dependency in two different modules.
* Feature modules directly depending on each other (causing circular dependencies).

---

### **11. How do you inject dependencies into a ViewModel with Hilt?**

```kotlin
@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: MyRepository
) : ViewModel()
```

Use `by viewModels()` in an `@AndroidEntryPoint` annotated activity or fragment.

---

### **12. What is the difference between `@HiltViewModel` and a normal ViewModel?**

`@HiltViewModel` integrates Hilt's dependency graph, enabling constructor injection for ViewModels.

---

### **13. What happens if you forget `@AndroidEntryPoint` on an Activity?**

The app will crash at runtime because Hilt can't generate the required entry points for dependency injection.

---

### **14. How do you create custom Hilt components or entry points?**

Use `@EntryPoint` to access Hilt dependencies from classes that Hilt can't inject into directly (e.g., ContentProviders).

---

### **15. How does Hilt handle multi-binding?**

Hilt supports `@IntoSet` and `@IntoMap` annotations to contribute multiple bindings into a single collection.

---

### **16. What is `EntryPointAccessors` and when would you use it?**

`EntryPointAccessors` allows you to access Hilt-provided dependencies in classes outside the DI graph, such as in third-party libraries or BroadcastReceivers.

---

### **17. How do you test modules and dependencies using Hilt?**

* Use `@HiltAndroidTest`.
* Provide test-specific bindings with `@TestInstallIn`.

---

### **18. How does Hilt improve build times in modularized projects?**

By isolating dependencies in modules, Hilt reduces the scope of generated code, speeding up incremental builds.

---

### **19. Would you prefer Hilt or manual DI for large-scale modular projects? Why?**

Hilt is preferable due to compile-time safety, reduced boilerplate, and built-in Android integrations.

---

### **20. How do you manage feature isolation and testing with Hilt?**

* Place shared dependencies in `core` modules.
* Feature modules remain isolated, consuming only dependencies they need.
* Use Hilt test bindings to swap real implementations with mocks.

---

## **Next Steps**

* Practice scenario-based questions (e.g., handling cross-feature dependencies).
* Explore testing with `@HiltAndroidTest` and `@TestInstallIn`.
