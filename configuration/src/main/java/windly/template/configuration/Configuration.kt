package windly.template.configuration

import dagger.Reusable
import windly.template.configuration.BuildConfig
import javax.inject.Inject

@Reusable
class Configuration @Inject constructor() {

  fun isDebug(): Boolean = BuildConfig.DEBUG

  fun serverUrl(): String =
    BuildConfig.URL
}
