plugins {
    id("org.jetbrains.compose") version "0.3.0-build139"
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
    compileSdkVersion(29)
    defaultConfig {
        applicationId = "com.plusmobileapps.android"
        minSdkVersion(24)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}