@file:Suppress("UnstableApiUsage")

import Build_gradle.Key.URL
import windly.template.ci.Application.packageName
import windly.template.ci.Build.Android
import windly.template.ci.Build.Version

plugins {
  id("com.android.library")
  kotlin("android")
  kotlin("kapt")
}

object Key {
  const val URL = "URL"
}

android {

  namespace = "$packageName.configuration"

  buildTypes {
    debug {
      isMinifyEnabled = false

      // TODO: Add injectable configuration.
      buildConfigField("String", URL, findProperty("ApiUrlDebug").toString())
    }
    release {
      isMinifyEnabled = false

      // TODO: Add injectable configuration.
      buildConfigField("String", URL, findProperty("ApiUrlRelease").toString())
    }
  }

  compileOptions {
    sourceCompatibility = Version.java
    targetCompatibility = Version.java
  }
  compileSdk = Android.compileSdk

  defaultConfig {
    minSdk = Android.minSdk
  }
}

dependencies {
  implementation(project(":base-android"))

  implementation(libs.hilt.android)
  kapt(libs.hilt.compiler)
}
