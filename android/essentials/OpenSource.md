
# Add in settings.gradle.kts

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        // jcenter() // Remove this as JCenter has been deprecated
        maven("https://jitpack.io") // Correct JitPack URL without extra spaces
        maven("https://maven.google.com/") // This is already covered by google()
    }
}
