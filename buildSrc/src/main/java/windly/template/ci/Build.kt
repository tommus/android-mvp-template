package windly.template.ci

import org.gradle.api.JavaVersion

object Build {

  object Android {
    const val compileSdk = 31
    const val minSdk = 27
    const val targetSdk = 31
  }

  object Version {
    val java = JavaVersion.VERSION_11
    const val kotlin = "1.8"
  }

  object Variant {
    const val DEBUG = "debug"
    const val RELEASE = "release"
  }
}
