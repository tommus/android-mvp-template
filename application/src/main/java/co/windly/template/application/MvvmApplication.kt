package co.windly.template.application

import co.windly.template.domain.DaggerDomainComponent
import co.windly.template.domain.DomainComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class MvvmApplication : DaggerApplication(), ApplicationComponent.ComponentProvider, DomainComponent.ComponentProvider {

  //region Application Injector

  override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
    applicationComponent

  //endregion

  //region Lifecycle

  override fun onCreate() {

    // Initialize application dependencies.
    initializeApplicationDependencies()

    // Continue with initialization.
    super.onCreate()
  }

  //endregion

  //region Application Dependencies

  override lateinit var applicationComponent: ApplicationComponent

  override lateinit var domainComponent: DomainComponent

  private fun initializeApplicationDependencies() {

    // Initialize domain component.
    domainComponent = DaggerDomainComponent.builder()
      .seedInstance(this)
      .build()

    // Initialize application component.
    applicationComponent = DaggerApplicationComponent.builder()
      .seedInstance(domainComponent)
      .build()

    // Inject dependencies.
    applicationComponent.inject(this)
  }

  //endregion
}
