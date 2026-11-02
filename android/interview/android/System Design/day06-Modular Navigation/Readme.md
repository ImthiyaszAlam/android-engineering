
# 🚀 Day 6 – Modular Navigation in Android System Design

## 🎯 Goal
- Add **navigation** between feature modules in a **modular Android project**.
- Keep features **decoupled** and navigation **scalable**.
- Prepare for interview questions like:  
  - *"How would you implement navigation in a large modular app?"*
  - *"How do you pass arguments between features without tight coupling?"*

---

## 🧱 **Architecture Diagram**

```

\:app
↓ (NavHostController)
\:core\:navigation
↓
┌───────────────┬────────────────┬────────────────┐
│ \:feature\:auth │ \:feature\:home  │ \:feature\:task  │
│   LoginScreen │   HomeScreen   │ TaskListScreen │
└───────────────┴────────────────┴────────────────┘

````

- **:app**: Hosts `MainActivity` and the root `NavHost`.
- **:core:navigation**: Contains routes, `Screen` sealed classes, and NavGraph extensions.
- **:feature:** modules: Each defines its own screens and UI logic.

---

## ⚙ **Step-by-Step Implementation**

### **1. Define Routes in `:core:navigation`**
```kotlin
sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Home : Screen("home")
    object TaskList : Screen("task_list")
    object AddTask : Screen("add_task")
}
````

---

### **2. Create NavGraph Extensions**

```kotlin
fun NavGraphBuilder.authGraph(navController: NavController) {
    composable(Screen.Login.route) {
        LoginScreen(
            onLoginSuccess = { navController.navigate(Screen.Home.route) }
        )
    }
}

fun NavGraphBuilder.homeGraph(navController: NavController) {
    composable(Screen.Home.route) {
        HomeScreen(
            onTasksClick = { navController.navigate(Screen.TaskList.route) }
        )
    }
}

fun NavGraphBuilder.taskGraph(navController: NavController) {
    composable(Screen.TaskList.route) {
        TaskListScreen(onAddTaskClick = {
            navController.navigate(Screen.AddTask.route)
        })
    }
    composable(Screen.AddTask.route) { AddTaskScreen() }
}
```

---

### **3. Setup Navigation in `MainActivity`**

```kotlin
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController, startDestination = Screen.Login.route) {
                authGraph(navController)
                homeGraph(navController)
                taskGraph(navController)
            }
        }
    }
}
```

---

### **4. Navigation Between Modules**

* Each **feature module** only exposes **its NavGraph builder** and **route strings**.
* `MainActivity` (or the `:app` module) assembles these NavGraphs.
* No direct `import` of feature screens across modules (only routes are known).

---

## ❓ **Interview Questions + Answers**

### **Q1. How do you keep modules decoupled?**

* By exposing **only route identifiers** and **NavGraph functions**, not the actual Composables or Activities.

---

### **Q2. How do you pass arguments between screens?**

* Use `navController.navigate("task_detail/$taskId")` and retrieve with `navBackStackEntry.arguments`.

---

### **Q3. How do you handle deep links?**

* Add `deepLink { uriPattern = "app://task/{taskId}" }` inside the `composable()` route definition.

---

### **Q4. What are alternatives to Jetpack Navigation?**

* You can build your own navigation manager using a **sealed class** and **StateFlow**.
* Some teams use **Decompose** or **Voyager** for Compose navigation.

---

### **Q5. How does navigation affect modular build times?**

* If you centralize all navigation in `:app`, you avoid cross-module coupling, leading to **faster incremental builds**.

---

## 🐞 **Debugging Scenario**

**Problem:** Login screen always restarts the app when navigating back.
**Fix:** Use `popUpTo(Screen.Login.route) { inclusive = true }` to clear the login screen from the back stack after login success.

---

## 🧠 **Day 6 Summary**

* We structured navigation **with sealed route classes**.
* Each feature module defines **its own NavGraph**.
* **MainActivity** stitches the navigation graph together.
* We tackled **argument passing, deep links, and modular decoupling.**

