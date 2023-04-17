package com.deanuharatinu.moviedatabase.common.di

import com.deanuharatinu.moviedatabase.common.data.MovieRepositoryImpl
import com.deanuharatinu.moviedatabase.common.data.remote.ApiService
import com.deanuharatinu.moviedatabase.common.domain.repositories.MovieRepository
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

object Modules {
  val core = module {
    single { ApiService.retrofit(get()) }
    single { ApiService.okhttpClient() }
    single { ApiService.movieApi(get()) }
  }
  val repositories = module {
    single<MovieRepository> { MovieRepositoryImpl(get(), get()) }
  }
}

fun initKoin(
  appModule: Module = module { },
  coreModule: Module = Modules.core,
  repositoriesModule: Module = Modules.repositories,
): KoinApplication = startKoin {
  modules(
    appModule,
    coreModule,
    repositoriesModule,
  )
}