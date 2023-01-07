package windly.template.ci

object Application {
  const val packageName = "windly.template"

  private const val applicationName = "TemplateApplication"
  private const val debugNameSuffix = "Development"

  object Debug {
    private const val dev = "dev"
    const val packageSuffix = ".$dev"
    const val versionSuffix = "($dev)"
  }

  /**
   * Provides a release application name.
   */
  fun releaseAppName(): String = applicationName

  /**
   * Provides a debug application name.
   */
  fun debugAppName(): String = "$applicationName $debugNameSuffix"
}
