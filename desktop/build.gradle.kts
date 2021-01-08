import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose") version Deps.JetBrains.Compose.VERSION
}

group = "com.plusmobileapps"
version = "1.0"

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = Deps.JetBrains.Compose.JVM_TARGET
        }
    }
    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation(project(":composeui"))
                implementation(project(":shared-code"))
                implementation(compose.desktop.currentOs)
            }
        }
        val jvmTest by getting
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "jvm"
        }
    }
}