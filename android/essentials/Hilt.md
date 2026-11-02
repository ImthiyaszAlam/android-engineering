    id("com.google.dagger.hilt.android") version "2.51.1" apply false

    dependencies {
    val hilt_version = "2.50"

    // Hilt Core
    implementation("com.google.dagger:hilt-android:$hilt_version")
    kapt("com.google.dagger:hilt-compiler:$hilt_version")

    // Hilt ViewModel extension (if using ViewModel)
    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03") // Optional
    kapt("androidx.hilt:hilt-compiler:1.0.0") // Optional
}

