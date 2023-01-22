import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import windly.template.ci.Build

buildscript {
  repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
  }
  dependencies {
    classpath(libs.bundles.gradle.plugins)
  }
}

subprojects {
  tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
      jvmTarget = Build.Version.kotlin
    }
  }
}

tasks.register("clean", Delete::class) {
  delete(rootProject.buildDir)
}
