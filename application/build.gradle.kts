@file:Suppress("UnstableApiUsage")

import com.android.build.gradle.ProguardFiles.ProguardFile.OPTIMIZE
import windly.template.ci.Application.Debug.packageSuffix
import windly.template.ci.Application.Debug.versionSuffix
import windly.template.ci.Application.debugAppName
import windly.template.ci.Application.packageName
import windly.template.ci.Application.releaseAppName
import windly.template.ci.Build.Android
import windly.template.ci.Build.Variant.DEBUG
import windly.template.ci.Build.Version
import windly.template.ci.Proguard.rules
import windly.template.tasks.PrintVersionTask

plugins {
  id("com.android.application")
  id("dagger.hilt.android.plugin")
  id("co.windly.versioning")
  kotlin("android")
  kotlin("kapt")
  id("kotlin-parcelize")
  id("androidx.navigation.safeargs.kotlin")
}

android {

  namespace = packageName

  buildFeatures {
    dataBinding = true
  }

  signingConfigs {
    getByName(DEBUG) {
      with(windly.template.ci.Keystore.Debug) {
        keyAlias = alias
        keyPassword = key
        storePassword = key
        storeFile = rootProject.file(path)
      }
    }
  }

  buildTypes {
    debug {
      applicationIdSuffix = packageSuffix
      resValue("string", "app_name", debugAppName())
      signingConfig = signingConfigs.getByName(DEBUG)
      versionNameSuffix = " $versionSuffix"
    }
    release {
      isMinifyEnabled = true
      proguardFiles(getDefaultProguardFile(OPTIMIZE.fileName), rules())
      resValue("string", "app_name", releaseAppName())
    }
  }

  compileOptions {
    sourceCompatibility = Version.java
    targetCompatibility = Version.java
  }
  compileSdk = Android.compileSdk

  defaultConfig {
    applicationId = packageName
    minSdk = Android.minSdk
    targetSdk = Android.targetSdk
    versionCode = versioning.versionCode()
    versionName = versioning.versionName()
  }
}

dependencies {

  implementation(project(":base"))
  implementation(project(":base-android"))
  implementation(project(":base-mvp"))
  implementation(project(":configuration"))
  implementation(project(":resources"))

  implementation(libs.androidx.constraintlayout)

  implementation(libs.hilt.android)
  kapt(libs.hilt.compiler)

  implementation(libs.google.material)
}

tasks.register<PrintVersionTask>(
  name = PrintVersionTask.NAME,
  versioning.versionCode(),
  versioning.versionName()
)
