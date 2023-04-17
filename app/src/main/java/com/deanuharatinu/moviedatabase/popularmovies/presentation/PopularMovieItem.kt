package com.deanuharatinu.moviedatabase.popularmovies.presentation

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.deanuharatinu.moviedatabase.common.domain.model.PopularMovies
import com.deanuharatinu.moviedatabase.ui.theme.MovieDatabaseTheme
import com.deanuharatinu.moviedatabase.ui.theme.Shapes

@Composable
fun PopularMovieItem(
  modifier: Modifier = Modifier,
  popularMovies: PopularMovies,
) {
  Card(
    modifier = modifier
      .wrapContentWidth(),
    shape = Shapes.medium,
  ) {
    AsyncImage(
      model = ImageRequest.Builder(LocalContext.current)
        .data(popularMovies.photoUrl)
        .crossfade(true)
        .memoryCacheKey(popularMovies.photoUrl)
        .build(),
      contentDescription = popularMovies.name,
      modifier = Modifier
        .height(250.dp)
        .wrapContentWidth(),
    )
  }
}

@Composable
@Preview(showBackground = true)
fun PopularMovieItemPreview() {
  MovieDatabaseTheme {
    Surface {
      PopularMovieItem(
        popularMovies = PopularMovies(
          "Mario",
          "http://image.tmdb.org/t/p/w300/qNBAXBIQlnOThrVvA6mA2B5ggV6.jpg",
        )
      )
    }
  }
}
