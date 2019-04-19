package co.windly.template.domain

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DomainModule::class])
interface DomainComponent {

  //region Component Builder

  @Component.Builder
  interface Builder {

    @BindsInstance
    fun seedInstance(context: Context): Builder

    fun build(): DomainComponent
  }

  //endregion

  //region Component Provider

  interface ComponentProvider {

    val domainComponent: DomainComponent
  }

  //endregion
}
