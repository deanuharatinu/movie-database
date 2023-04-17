package com.deanuharatinu.moviedatabase.common.domain.model

data class PopularMovies(
  val name: String,
  val photoUrl: String,
) {
  companion object {
    val emptyPopularMovies: PopularMovies
      get() = PopularMovies("", "")
  }
}


