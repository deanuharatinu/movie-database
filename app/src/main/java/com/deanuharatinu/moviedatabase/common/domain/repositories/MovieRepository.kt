package com.deanuharatinu.moviedatabase.common.domain.repositories

import com.deanuharatinu.moviedatabase.common.domain.model.PopularMovies
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
  fun getPopularMovies(): Flow<List<PopularMovies>>
}