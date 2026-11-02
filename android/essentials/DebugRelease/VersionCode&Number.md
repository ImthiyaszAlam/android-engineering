

# **📌 Managing Different Version Codes and Version Names in Android** 

# This guide explains how to set **different `versionCode` and `versionName`** for **debug** and **release** builds in an Android project using Gradle
---

## **1. Define Different Version Codes and Names**  
Modify your `app/build.gradle` file inside the `android` block:  

```gradle
android {
    defaultConfig {
        applicationId "com.your.package"
        minSdk 24
        targetSdk 34
    }

    buildTypes {
        debug {
            versionCode 56
            versionName "4.0.2-debug"
        }
        release {
            versionCode 56
            versionName "4.0.2"
            minifyEnabled true
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
}
```

---

## **2. Access Version Details in Kotlin**  
You can retrieve these values dynamically in your app using:  

```kotlin
val versionCode = BuildConfig.VERSION_CODE
val versionName = BuildConfig.VERSION_NAME
Log.d("AppVersion", "Version Code: $versionCode, Version Name: $versionName")
```

---

## **3. Behavior**  
- **Debug build:**  
  - `versionCode = 100`  
  - `versionName = "100.0.2-debug"`  

- **Release build:**  
  - `versionCode = 200`  
  - `versionName = "200.0.2"`  

---

## **Conclusion**  
By defining `versionCode` and `versionName` separately for **debug** and **release** builds, you can easily differentiate them without manual changes before releasing your app. 🚀
