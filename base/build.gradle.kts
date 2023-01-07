import windly.template.ci.Libs

plugins {
  id("kotlin")
  kotlin("kapt")
}

dependencies {
  api(Libs.Kotlin.stdJdk8)
  implementation(Libs.Rx.java)
  implementation(Libs.MapStruct.runtime)
}
