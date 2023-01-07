import windly.template.ci.Build.Android
import windly.template.ci.Build.Version
import windly.template.ci.Libs
import windly.template.ci.Proguard

plugins {
  id("com.android.library")
  kotlin("android")
  kotlin("kapt")
}

android {

  compileOptions {
    sourceCompatibility = Version.java
    targetCompatibility = Version.java
  }
  compileSdk = Android.compileSdk

  defaultConfig {
    consumerProguardFiles(windly.template.ci.Proguard.CONSUMER)
    minSdk = Android.minSdk
  }
}

dependencies {

  implementation(project(":base"))
  implementation(project(":resources"))

  implementation(Libs.Dagger.hilt)
  kapt(Libs.Dagger.compiler)

  api(Libs.Debug.timber)

  implementation(Libs.Rx.android)
  implementation(Libs.Rx.java)
}
