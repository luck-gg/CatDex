// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        val hiltVersion by extra("2.52")
        classpath("com.google.dagger:hilt-android-gradle-plugin:$hiltVersion")
    }
} // Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    id("org.jetbrains.kotlin.android") version "2.0.10" apply false
    id("com.google.devtools.ksp") version "2.0.10-1.0.24" apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.10" apply false
}

tasks.register("clean", Delete::class) {
    description = "Cleans the build directory"
    group = "clean"
    delete(rootProject.layout.buildDirectory)
}
