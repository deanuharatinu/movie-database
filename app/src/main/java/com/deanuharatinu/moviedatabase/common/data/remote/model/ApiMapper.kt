package com.deanuharatinu.moviedatabase.common.data.remote.model

import com.deanuharatinu.moviedatabase.common.domain.model.PopularMovies

fun Result.toDomain(): PopularMovies {
  return PopularMovies(
    name = this.originalTitle.orEmpty(),
    photoUrl = this.posterPath?.getImageUrl().orEmpty(),
  )
}

fun String.getImageUrl(): String {
  return "http://image.tmdb.org/t/p/w300${this}"
}
