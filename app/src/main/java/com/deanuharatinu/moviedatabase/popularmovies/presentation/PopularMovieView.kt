package com.deanuharatinu.moviedatabase.popularmovies.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deanuharatinu.moviedatabase.common.domain.model.PopularMovies
import com.deanuharatinu.moviedatabase.ui.theme.MovieDatabaseTheme
import org.koin.androidx.compose.getViewModel

@Composable
fun PopularMovieView(
  modifier: Modifier = Modifier,
  viewModel: PopularMoviesViewModel = getViewModel(),
) {
  val popularMovieList by viewModel.uiState.collectAsState()

  Box(
    modifier = modifier
      .safeContentPadding(),
  ) {
    PopularMovieContent(popularMoviesUiState = popularMovieList)
  }
}

@Composable
fun PopularMovieContent(
  popularMoviesUiState: PopularMoviesUiState,
) {
  when (popularMoviesUiState) {
    is PopularMoviesUiState.Success -> {
      return PopularMovieList(
        popularMovieList = popularMoviesUiState.popularMovieList
      )
    }

    else -> {
      // TODO: when error
    }
  }

}

@Composable
fun PopularMovieList(
  modifier: Modifier = Modifier,
  popularMovieList: List<PopularMovies>,
) {
  LazyVerticalGrid(
    modifier = modifier,
    contentPadding = PaddingValues(vertical = 16.dp),
    columns = GridCells.Fixed(2),
    verticalArrangement = Arrangement.spacedBy(16.dp),
    horizontalArrangement = Arrangement.SpaceEvenly,
  ) {
    items(popularMovieList) { popularMovie ->
      PopularMovieItem(popularMovies = popularMovie)
    }
  }
}

@Composable
@Preview(showBackground = true)
fun PopularMovieContentPreview() {
  MovieDatabaseTheme {
    Surface(
      modifier = Modifier.fillMaxSize(),
      color = MaterialTheme.colors.background
    ) {
      PopularMovieList(
        popularMovieList = listOf(
          PopularMovies(
            "Mario 1",
            "http://image.tmdb.org/t/p/w300/qNBAXBIQlnOThrVvA6mA2B5ggV6.jpg"
          ),
          PopularMovies(
            "Mario 2",
            "http://image.tmdb.org/t/p/w300/qNBAXBIQlnOThrVvA6mA2B5ggV6.jpg"
          ),
        ),
      )
    }
  }
}