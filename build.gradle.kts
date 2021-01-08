buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Deps.JetBrains.Kotlin.gradlePlugin)
        classpath(Deps.Android.Tools.Build.gradlePlugin)
        classpath(Deps.Squareup.SQLDelight.gradlePlugin)
    }
}

group = "com.plusmobileapps"
version = "1.0"

allprojects {
    repositories {
        jcenter()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}