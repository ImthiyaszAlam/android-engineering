plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
}

android {
    namespace = "com.imthiyas.quizapp"
    compileSdk = 35

    viewBinding {
        enable = true
    }

    defaultConfig {
        applicationId = "com.imthiyas.quizapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // 🗃️ Room Database (For Caching Questions)
    implementation (libs.androidx.room.runtime)
  //  kapt ("androidx.room:room-compiler:2.5.0")
    implementation (libs.androidx.room.ktx)

    // ⚡ Hilt (For Dependency Injection)
    implementation (libs.hilt.android.v244)
   // kapt "com.google.dagger:hilt-compiler:2.44"

    // 🔄 Coroutines (For Async API Calls)
    implementation (libs.kotlinx.coroutines.android)
    implementation (libs.androidx.lifecycle.viewmodel.ktx)
    implementation (libs.androidx.lifecycle.livedata.ktx)

    // 🖼️ Jetpack Compose (For UI - Optional)
    implementation (libs.androidx.activity.compose)
    implementation (libs.androidx.ui)
    implementation (libs.androidx.material)

    // 🏗️ Navigation Component (For Fragment Navigation)
    implementation (libs.androidx.navigation.fragment.ktx)
    implementation (libs.androidx.navigation.ui.ktx)

    // 🗂️ View Binding (For Easier UI Handling)
    implementation (libs.androidx.viewbinding)

    // 🌟 Material Design
    implementation (libs.material.v180)

    // 🛠️ Gson (For JSON Parsing)
    implementation (libs.gson)

    // 💾 Shared Preferences (For Saving High Scores)
    implementation (libs.androidx.preference.ktx)

    implementation(libs.dagger.hilt.android)
    kapt(libs.hilt.compiler)

    implementation(libs.androidx.fragment.ktx)
}