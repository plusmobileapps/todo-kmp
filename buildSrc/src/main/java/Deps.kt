object Deps {

    object JetBrains {
        object Kotlin {
            // __KOTLIN_COMPOSE_VERSION__
            private const val VERSION = "1.4.21"
            const val COROUTINES_VERSION = "1.4.2-native-mt"
            const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$VERSION"
            const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$COROUTINES_VERSION"
            const val testCommon = "org.jetbrains.kotlin:kotlin-test-common:$VERSION"
            const val testAnnotationsCommon = "org.jetbrains.kotlin:kotlin-test-annotations-common:$VERSION"
        }

        object Compose {
            const val JVM_TARGET = "11"
            // __LATEST_COMPOSE_RELEASE_VERSION__
            const val VERSION = "0.3.0-build139"
            const val gradlePlugin = "org.jetbrains.compose:compose-gradle-plugin:$VERSION"
        }
    }

    object Android {
        const val minSdk = 24
        const val targetSdk = 29
        const val compileSdk = 29
        object Tools {
            object Build {
                const val gradlePlugin = "com.android.tools.build:gradle:4.0.1"
            }
        }
    }
    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:1.2.0"
        const val coreKtx = "androidx.core:core-ktx:1.3.2"

        object Test {
            const val junit = "junit:junit:4.13.1"
        }
    }

    object Squareup {
        object SQLDelight {
            private const val VERSION = "1.4.4"
            const val gradlePlugin = "com.squareup.sqldelight:gradle-plugin:$VERSION"
            const val androidDriver = "com.squareup.sqldelight:android-driver:$VERSION"
            const val sqliteDriver = "com.squareup.sqldelight:sqlite-driver:$VERSION"
            const val coroutineExtensions = "com.squareup.sqldelight:coroutines-extensions:$VERSION"
        }
    }
}