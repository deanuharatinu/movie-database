package com.deanuharatinu.moviedatabase.common.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemotePopularMovies(
  val page: Int?,
  val results: List<Result?>?,
  @field:Json(name = "total_pages")
  val totalPages: Int?,
  @field:Json(name = "total_results")
  val totalResults: Int?
)

@JsonClass(generateAdapter = true)
data class Result(
  val id: Int?,
  val adult: Boolean?,
  @field:Json(name = "backdrop_path")
  val backdropPath: String?,
  @field:Json(name = "genre_ids")
  val genreIds: List<Int?>?,
  @field:Json(name = "original_language")
  val originalLanguage: String?,
  @field:Json(name = "original_title")
  val originalTitle: String?,
  val overview: String?,
  val popularity: Double?,
  @field:Json(name = "poster_path")
  val posterPath: String?,
  @field:Json(name = "release_date")
  val releaseDate: String?,
  val title: String?,
  val video: Boolean?,
  @field:Json(name = "vote_average")
  val voteAverage: Double?,
  @field:Json(name = "vote_count")
  val voteCount: Int?
)