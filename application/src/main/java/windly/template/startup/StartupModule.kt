package windly.template.startup

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import windly.template.lifecycle.RunOnStartup

@[Module InstallIn(SingletonComponent::class)]
abstract class StartupModule {

  @[Binds IntoSet RunOnStartup]
  internal abstract fun configureLogger(runnable: ConfigureTimber): Runnable
}
