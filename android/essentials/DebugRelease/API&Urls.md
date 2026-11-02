

# **📌 Handling Different API Credentials for Debug & Release in Android**  

### **🔹 Why Use Different API Credentials?**  
When developing an Android app, you often need **different API credentials** for:  
- **Debug builds** (for development and testing)  
- **Release builds** (for production)  

Instead of **manually changing API keys**, you can define them in **`build.gradle`** using `buildConfigField`. This ensures:  
✅ Debug builds use **testing API keys**.  
✅ Release builds use **production API keys**.  
✅ Developers **don’t need to modify code** when switching between environments.  

---

## **📌 1️⃣ How to Enable `BuildConfig`?**  
To make sure `BuildConfig` is generated properly, add the following inside `build.gradle (Module: app)`:  

```gradle
android {
    buildFeatures {
        buildConfig = true  // ✅ This explicitly enables BuildConfig generation
    }
}
```

This ensures `BuildConfig` is always available and prevents issues like **"Unresolved reference: BuildConfig"**.

---

## **📌 2️⃣ How to Define Credentials in `build.gradle`**
You can define different API credentials **inside `build.gradle (Module: app)`** like this:  

```gradle
android {
    buildTypes {
        
        // 🔹 Debug build type - Used for testing
        debug {
            buildConfigField("String", "BASE_URL", "\"https://apiurl1.com1/\"")
            buildConfigField("String", "AWS_API_KEY", "\"api_key_debug\"")
            buildConfigField("String", "AWS_API_SECRET", "\"api_secret_debug\"")
        }

        // 🔹 Release build type - Used for production
        release {
            buildConfigField("String", "BASE_URL", "\"https://apiurl2.com/\"")
            buildConfigField("String", "AWS_API_KEY", "\"api_key_release\"")
            buildConfigField("String", "AWS_API_SECRET", "\"api_secret_release\"")

            // ✅ Enable code shrinking & obfuscation for security
            isMinifyEnabled = true  
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), 
                "proguard-rules.pro"
            )
        }
    }
}
```

---

## **📌 3️⃣ How to Access These Values in Your Code?**  
Once added in `build.gradle`, you can access them **directly in Kotlin/Java** using `BuildConfig` like this:  

### **Kotlin Example**
```kotlin
val baseUrl = BuildConfig.BASE_URL
val awsApiKey = BuildConfig.AWS_API_KEY
val awsApiSecret = BuildConfig.AWS_API_SECRET
```

### **Java Example**
```java
String baseUrl = BuildConfig.BASE_URL;
String awsApiKey = BuildConfig.AWS_API_KEY;
String awsApiSecret = BuildConfig.AWS_API_SECRET;
```

👉 **When you run a Debug build**, it will use **Debug credentials**.   
👉 **When you build for Release**, it will automatically use **Production credentials**. ✅  

---

## **📌 4️⃣ What is `BuildConfig` and Where is It Located?**
`BuildConfig` is an **auto-generated class** created by Gradle during the build process.  
It is located inside:  
```
app/build/generated/source/buildConfig/debug/com/imthiyas/BuildConfig.java
```

### **🔹 Example of Generated `BuildConfig.java`**
After building the project, `BuildConfig.java` will look like this:  

```java
package com.imthiyas;

public final class BuildConfig {
    public static final String BASE_URL = "https://api.imthiyas.org/";  // Debug mode
    public static final String AWS_API_KEY = "api_key_debug";
    public static final String AWS_API_SECRET = "api_secret_debug";
}
```
📌 **Note:** In Release mode, values will be different based on the `release` configuration.

---

## **📌 5️⃣ How to Fix "Unresolved Reference: BuildConfig"?**
If `BuildConfig` is **not generated**, try these steps:  

✅ **1. Enable `buildConfig` in `build.gradle`**  
Make sure you have:  
```gradle
android {
    buildFeatures {
        buildConfig = true
    }
}
```

✅ **2. Sync Gradle**  
Go to **Android Studio** → Click on **File** → Select **Sync Project with Gradle Files**  

✅ **3. Rebuild the Project**  
Go to **Build** → Click **Rebuild Project**  

✅ **4. Check the Imports**  
Make sure you have the correct import statement in your Kotlin/Java file:  
```kotlin
import com.imthiyas.BuildConfig
```
📌 Replace `com.imthiyas` with your actual package name.

✅ **5. Enable Gradle Auto-Build**  
In Android Studio:  
Go to **Settings → Build, Execution, Deployment → Compiler**  
✅ Check **"Build automatically"**  

---

## **📌 6️⃣ Why Use This Approach?**  
✔ **No manual switching** – The correct API keys are used automatically.  
✔ **Prevents accidental production access** – Ensures that testing doesn't interfere with real users.  
✔ **Security** – Avoids storing API keys directly in the code.  
