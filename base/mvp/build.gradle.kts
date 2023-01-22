import windly.template.ci.Application.packageName
import windly.template.ci.Build.Android
import windly.template.ci.Build.Version
import windly.template.ci.Proguard.CONSUMER

plugins {
  id("com.android.library")
  kotlin("android")
}

android {

  namespace = "$packageName.mvp"

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
  implementation(libs.androidx.lifecycle)
  implementation(libs.kotlin.stdlib)
  implementation(libs.rx.java)
}
