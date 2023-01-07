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

  namespace = "windly.template.common.persistence"

  buildFeatures {
    buildConfig = false
  }

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

  api(Libs.Androidx.datastorePreferences)

  api(Libs.Androidx.Room.runtime)
  api(Libs.Androidx.Room.ktx)
  api(Libs.Androidx.Room.rxJava3)
  kapt(Libs.Androidx.Room.compiler)

  implementation(Libs.Dagger.hilt)
  kapt(Libs.Dagger.compiler)
}
