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

  namespace = "windly.template.common.network"

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
  implementation(project(":configuration"))

  implementation(Libs.Dagger.hilt)
  kapt(Libs.Dagger.compiler)

  implementation(Libs.Json.Moshi.moshi)
  kapt(Libs.Json.Moshi.codegen)

  api(Libs.Network.Retrofit.moshi)
  api(Libs.Network.Retrofit.retrofit)
  api(Libs.Network.Retrofit.rxJava3)
  implementation(Libs.Network.loggingInterceptor)

  implementation(Libs.Windly.Limbo.utility)
}
