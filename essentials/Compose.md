

---

## 🚀 **Project-Level `build.gradle.kts` (Top-Level Build File)**  
This file manages dependencies common to all submodules.

### **Using Version Catalog (`libs.versions.toml`)**
```kotlin
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}
```
✅ This method allows versioning to be managed inside `libs.versions.toml`, making updates easier.

#### **Example of `libs.versions.toml`**
```toml
[versions]
agp = "8.7.2"
kotlin = "1.9.24"

[plugins]
android-application = { id = "com.android.application", version.ref = "agp" }
kotlin-android = { id = "org.jetbrains.kotlin.android", version.ref = "kotlin" }
```
👉 **No need to specify versions inside `build.gradle.kts`**; they are managed in `libs.versions.toml`.

---

### **OR: Without Version Catalogs (Direct Versioning)**
If you prefer not to use `libs.versions.toml`, you can directly specify plugin versions:
```kotlin
plugins {
    id("com.android.application") version "8.7.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.24" apply false
}
```
✅ This approach works without `libs.versions.toml`, but updating versions requires manual changes.

---

## 📌 **Module-Level `build.gradle.kts` (App-Level)**
Each module (like `:app`) has its own `build.gradle.kts`.  

### **Using Version Catalogs**
```kotlin
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}
```

### **OR: Without Version Catalogs**
```kotlin
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}
```

---

## 🎨 **Enabling Jetpack Compose in `android` Block**
To use Jetpack Compose in your project, add this inside `android {}`:
```kotlin
buildFeatures {
    compose = true
}
composeOptions {
    kotlinCompilerExtensionVersion = "1.5.14"
    kotlinCompilerVersion = "1.9.0"
}
```

---

## 📦 **Jetpack Compose Dependencies (`dependencies` block)**
```kotlin
dependencies {
    // Jetpack Compose core libraries
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation("androidx.compose.ui:ui:1.7.8")
    implementation("androidx.compose.material3:material3:1.3.1")
    implementation("androidx.compose.ui:ui-tooling-preview:1.7.8")
    debugImplementation("androidx.compose.ui:ui-tooling:1.7.8")

    // Compose Icons
    implementation("androidx.compose.material:material-icons-extended:1.7.8")
}
```

---
