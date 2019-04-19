package co.windly.template.domain

import co.windly.template.network.NetworkModule
import dagger.Module

@Module(includes = [
  NetworkModule::class,
  PersistenceModule::class
])
class DomainModule
