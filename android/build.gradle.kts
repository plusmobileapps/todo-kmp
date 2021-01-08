plugins {
    id("org.jetbrains.compose") version Deps.JetBrains.Compose.VERSION
    id("com.android.application")
    kotlin("android")
}

group = "com.plusmobileapps"
version = "1.0"

repositories {
    google()
}

dependencies {
    implementation(project(":composeui"))
    implementation(project(":shared-code"))
}

android {
    compileSdkVersion(Deps.Android.compileSdk)
    defaultConfig {
        applicationId = "com.plusmobileapps.android"
        minSdkVersion(Deps.Android.minSdk)
        targetSdkVersion(Deps.Android.targetSdk)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}