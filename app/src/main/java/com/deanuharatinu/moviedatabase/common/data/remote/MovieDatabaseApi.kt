package com.deanuharatinu.moviedatabase.common.data.remote

import com.deanuharatinu.moviedatabase.common.data.remote.model.RemotePopularMovies
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDatabaseApi {
  @GET(ApiConstants.MOVIE_POPULAR)
  suspend fun getPopularMovies(
    @Query(ApiParameters.API_KEY) apiKey: String,
  ): RemotePopularMovies
}
