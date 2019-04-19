package co.windly.template.presentation

import co.windly.template.presentation.main.MainModule
import dagger.Module
import dagger.android.support.AndroidSupportInjectionModule

@Module(includes = [
  AndroidSupportInjectionModule::class,
  MainModule::class
])
class PresentationModule
