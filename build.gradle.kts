// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        val hiltVersion by extra("2.52")
        classpath("com.google.dagger:hilt-android-gradle-plugin:$hiltVersion")
    }
} // Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.5.2" apply false
    id("com.android.library") version "8.5.2" apply false
    id("org.jetbrains.kotlin.android") version "2.0.10" apply false
    id("com.google.devtools.ksp") version "2.0.10-1.0.24" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.layout.buildDirectory)
}
// plugins {
//    alias(libs.plugins.android.application) apply false
//    alias(libs.plugins.org.jetbrains.kotlin.android) apply false
//    alias(libs.plugins.compose.compiler) apply false
//    id("com.google.devtools.ksp") version "2.0.10-1.0.24" apply false
//    id("com.google.dagger.hilt.android") version "2.52" apply false
// }
