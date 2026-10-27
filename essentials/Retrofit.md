dependencies {
    val retrofit_version = "2.9.0"

    implementation("com.squareup.retrofit2:retrofit:$retrofit_version")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit_version") // For JSON conversion

    // If using Moshi instead of Gson
    implementation("com.squareup.retrofit2:converter-moshi:$retrofit_version")
}

