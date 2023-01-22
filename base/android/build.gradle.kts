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

  namespace = "$packageName.android"

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
  implementation(project(":resources"))

  implementation(libs.hilt.android)
  kapt(libs.hilt.compiler)

  implementation(libs.rx.android)
  implementation(libs.rx.binding)
  implementation(libs.rx.java)

  api(libs.timber)
}
