package windly.template.ci

object Libs {

  object Android {
    const val gradlePlugin = "com.android.tools.build:gradle:7.3.1"
    const val material = "com.google.android.material:material:1.7.0"
  }

  object Androidx {

    const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.4"
    const val datastorePreferences = "androidx.datastore:datastore-preferences:1.0.0"
    const val lifecycle = "androidx.lifecycle:lifecycle-common-java8:2.5.1"

    object Navigation {
      private const val version = "2.5.3"
      const val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:$version"
      const val gradlePlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:$version"
      const val uiKtx = "androidx.navigation:navigation-ui-ktx:$version"
    }

    object Room {
      private const val version = "2.4.3"
      const val compiler = "androidx.room:room-compiler:$version"
      const val ktx = "androidx.room:room-ktx:$version"
      const val runtime = "androidx.room:room-runtime:$version"
      const val rxJava3 = "androidx.room:room-rxjava3:$version"
    }
  }

  object Dagger {
    private const val version = "2.44.2"
    const val compiler = "com.google.dagger:hilt-compiler:$version"
    const val gradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
    const val hilt = "com.google.dagger:hilt-android:$version"
  }

  object Debug {
    const val timber = "com.jakewharton.timber:timber:5.0.1"
  }

  object Google {
    object Services {
      const val gradlePlugin = "com.google.gms:google-services:4.3.14"
    }
  }

  object Json {
    object Moshi {
      private const val version = "1.14.0"
      const val moshi = "com.squareup.moshi:moshi:$version"
      const val codegen = "com.squareup.moshi:moshi-kotlin-codegen:$version"
    }
  }

  object Kotlin {
    private const val version = "1.8.0"
    const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    const val stdJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
  }

  object MapStruct {
    private const val version = "1.5.3.Final"
    const val runtime = "org.mapstruct:mapstruct:$version"
    const val processor = "org.mapstruct:mapstruct-processor:$version"
  }

  object Network {

    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:4.10.0"

    object Retrofit {
      private const val version = "2.9.0"
      const val moshi = "com.squareup.retrofit2:converter-moshi:$version"
      const val retrofit = "com.squareup.retrofit2:retrofit:$version"
      const val rxJava3 = "com.squareup.retrofit2:adapter-rxjava3:$version"
    }
  }

  object Rx {
    const val android = "io.reactivex.rxjava2:rxandroid:2.1.1"
    const val java = "io.reactivex.rxjava2:rxjava:2.2.21"
  }

  object Ui {
    object FastAdapter {
      private const val version = "5.7.0"
      const val binding = "com.mikepenz:fastadapter-extensions-binding:$version"
      const val core = "com.mikepenz:fastadapter:$version"
      const val utils = "com.mikepenz:fastadapter-extensions-utils:$version"
    }
  }

  object Windly {
    object Limbo {
      const val utility = "co.windly:limbo-utility:3.2.2"
    }
    object Versioning {
      const val gradlePlugin = "co.windly:versioning-gradle-plugin:1.1.2"
    }
  }
}
