@file:Suppress("UnstableApiUsage")

import windly.template.ci.Application.packageName
import windly.template.ci.Build.Android
import windly.template.ci.Build.Version
import windly.template.ci.Proguard.CONSUMER

plugins {
  id("com.android.library")
  kotlin("android")
  kotlin("kapt")
}

android {

  namespace = "$packageName.persistence"

  buildFeatures {
    buildConfig = false
  }

  compileOptions {
    sourceCompatibility = Version.java
    targetCompatibility = Version.java
  }
  compileSdk = Android.compileSdk

  defaultConfig {
    consumerProguardFiles(CONSUMER)
    minSdk = Android.minSdk
  }
}

dependencies {

  implementation(project(":base:language"))
  api(libs.androidx.datastore.preferences)

  api(libs.androidx.room.runtime)
  api(libs.androidx.room.ktx)
  api(libs.androidx.room.rxjava3)
  kapt(libs.androidx.room.compiler)

  implementation(libs.hilt.android)
  kapt(libs.hilt.compiler)
}
