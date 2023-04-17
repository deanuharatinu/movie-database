package com.deanuharatinu.moviedatabase.common.data

import com.deanuharatinu.moviedatabase.common.data.remote.MovieDatabaseApi
import com.deanuharatinu.moviedatabase.common.data.remote.model.toDomain
import com.deanuharatinu.moviedatabase.common.domain.model.PopularMovies
import com.deanuharatinu.moviedatabase.common.domain.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieRepositoryImpl(
  private val movieApi: MovieDatabaseApi,
  private val apiKey: String,
  ) : MovieRepository {
  override fun getPopularMovies(): Flow<List<PopularMovies>> {
    return flow {
      val popularMovieList = movieApi.getPopularMovies(apiKey)
        .results?.map {
          it?.toDomain() ?: PopularMovies.emptyPopularMovies
        }.orEmpty()
      emit(popularMovieList)
    }
  }
}
