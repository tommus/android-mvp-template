package windly.template.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import windly.template.android.lifecycle.RunOnStartup
import javax.inject.Inject

@HiltAndroidApp
class TemplateApplication : Application() {

  @[Inject RunOnStartup]
  lateinit var tasks: Set<@JvmSuppressWildcards Runnable>

  override fun onCreate() {
    super.onCreate()

    // Tasks might be heavy.
    // Maybe it's worth to move them to background thread?
    tasks.forEach(Runnable::run)
  }
}
