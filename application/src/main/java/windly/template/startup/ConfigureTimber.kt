package windly.template.startup

import windly.template.configuration.Configuration
import timber.log.Timber
import javax.inject.Inject

class ConfigureTimber @Inject constructor(
  private val configuration: Configuration,
  private val debug: Timber.DebugTree
) : Runnable {

  /**
   * Plants logging tree based on configuration preference.
   */
  override fun run() {
    if (configuration.isDebug()) {
      Timber.plant(debug)
    }
  }
}
