@file:Suppress("UnstableApiUsage")

import windly.template.ci.Application.packageName
import windly.template.ci.Build.Android
import windly.template.ci.Build.Version

plugins {
  id("com.android.library")
  kotlin("android")
  kotlin("kapt")
}

android {

  namespace = "$packageName.resources"

  buildFeatures {
    buildConfig = false
  }

  compileOptions {
    sourceCompatibility = Version.java
    targetCompatibility = Version.java
  }
  compileSdk = Android.compileSdk
}

dependencies {
  implementation(libs.google.material)
  implementation(libs.hilt.android)
  kapt(libs.hilt.compiler)
}
