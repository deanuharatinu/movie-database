package com.deanuharatinu.moviedatabase

import android.app.Application
import android.content.Context
import com.deanuharatinu.moviedatabase.common.di.initKoin
import com.deanuharatinu.moviedatabase.popularmovies.presentation.PopularMoviesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class MovieDatabaseApp : Application() {

  override fun onCreate() {
    super.onCreate()

    initKoin(
      appModule = module {
        single<Context> { this@MovieDatabaseApp }
        single { BuildConfig.MOVIE_DB_API_KEY }
        viewModel { PopularMoviesViewModel(get()) }
      },
    )
  }
}