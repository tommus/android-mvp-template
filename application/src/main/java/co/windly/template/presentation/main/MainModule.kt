package co.windly.template.presentation.main

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainModule {

  //region Contribution

  @ContributesAndroidInjector
  abstract fun contributeAndroidInjector(): MainActivity

  //endregion
}
