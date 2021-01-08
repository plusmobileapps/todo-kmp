plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("com.squareup.sqldelight")
}

group = "com.plusmobileapps"
version = "1.0"

repositories {
    mavenCentral()
    google()
    jcenter()
}

kotlin {
    /* Targets configuration omitted.
    *  To find out how to configure the targets, please follow the link:
    *  https://kotlinlang.org/docs/reference/building-mpp-with-gradle.html#setting-up-targets */
    android()
    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = Deps.JetBrains.Compose.JVM_TARGET
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation(Deps.JetBrains.Kotlin.coroutines)  {
                    version {
                        strictly(Deps.JetBrains.Kotlin.COROUTINES_VERSION)
                    }
                }
                implementation(Deps.Squareup.SQLDelight.coroutineExtensions)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(Deps.JetBrains.Kotlin.testCommon)
                implementation(Deps.JetBrains.Kotlin.testAnnotationsCommon)
            }
        }

        val androidMain by getting {
            dependencies {
                api(Deps.AndroidX.appCompat)
                api(Deps.AndroidX.coreKtx)
                implementation(Deps.Squareup.SQLDelight.androidDriver)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(Deps.AndroidX.Test.junit)
            }
        }
        val desktopMain by getting {
            dependencies {
                implementation(Deps.Squareup.SQLDelight.sqliteDriver)
            }
        }
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

sqldelight {
    database("MyDatabase") {
        packageName = "com.plusmobileapps.sharedcode.db"
        sourceFolders = listOf("sqldelight")
    }
}