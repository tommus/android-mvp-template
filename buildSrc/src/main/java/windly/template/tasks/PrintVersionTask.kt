package windly.template.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import javax.inject.Inject

abstract class PrintVersionTask @Inject constructor(
  private val versionCode: Int,
  private val versionName: String
) : DefaultTask() {

  @TaskAction
  fun print() {
    println()
    println("---------- VERSION DATA ----------")
    println("-> CODE: $versionCode")
    println("-> NAME: $versionName")
    println("----------------------------------")
    println()
  }
}
