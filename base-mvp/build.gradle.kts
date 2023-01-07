import windly.template.ci.Build.Android
import windly.template.ci.Build.Version
import windly.template.ci.Libs
import windly.template.ci.Proguard

plugins {
  id("com.android.library")
  kotlin("android")
}

android {

  namespace = "windly.template.mvp"

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
  implementation(Libs.Androidx.lifecycle)
  implementation(Libs.Kotlin.stdJdk8)
  implementation(Libs.Rx.java)
}
