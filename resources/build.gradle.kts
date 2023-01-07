import windly.template.ci.Build.Android
import windly.template.ci.Build.Version
import windly.template.ci.Libs

plugins {
  id("com.android.library")
  kotlin("android")
  kotlin("kapt")
}

android {

  namespace = "windly.template.resources"

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
  implementation(Libs.Android.material)
  implementation(Libs.Dagger.hilt)
  kapt(Libs.Dagger.compiler)
}
