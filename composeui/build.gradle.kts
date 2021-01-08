import org.jetbrains.compose.compose

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose") version Deps.JetBrains.Compose.VERSION
    id("com.android.library")
}

group = "com.plusmobileapps"
version = "1.0"

repositories {
    google()
}

kotlin {
    android()
    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
                implementation(project(":shared-code"))
            }
        }
        val commonTest by getting
        val androidMain by getting {
            dependencies {
                api(Deps.AndroidX.appCompat)
                api(Deps.AndroidX.coreKtx)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(Deps.AndroidX.Test.junit)
            }
        }
        val desktopMain by getting
        val desktopTest by getting
    }
}

android {
    compileSdkVersion(Deps.Android.compileSdk)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(Deps.Android.minSdk)
        targetSdkVersion(Deps.Android.targetSdk)
    }
}