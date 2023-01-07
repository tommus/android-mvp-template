package windly.template.log

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import timber.log.Timber
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
object TimberModule {

  @[Provides Singleton]
  internal fun debugTree(): Timber.DebugTree =
    Timber.DebugTree()
}
