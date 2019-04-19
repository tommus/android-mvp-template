package co.windly.template.application

import co.windly.template.domain.DomainComponent
import co.windly.template.presentation.PresentationModule
import co.windly.template.utility.UtilityModule
import dagger.Component
import dagger.android.AndroidInjector

@ApplicationScope
@Component(
  dependencies = [DomainComponent::class],
  modules = [
    PresentationModule::class,
    UtilityModule::class
  ])
interface ApplicationComponent : AndroidInjector<MvvmApplication> {

  //region Component Builder

  @Component.Builder
  interface Builder {

    fun seedInstance(component: DomainComponent): Builder

    fun build(): ApplicationComponent
  }

  //endregion

  //region Component Provider

  interface ComponentProvider {

    val applicationComponent: ApplicationComponent
  }

  //endregion
}
