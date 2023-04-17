package com.deanuharatinu.moviedatabase.popularmovies.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deanuharatinu.moviedatabase.common.domain.model.PopularMovies
import com.deanuharatinu.moviedatabase.common.domain.repositories.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PopularMoviesViewModel(repository: MovieRepository) : ViewModel() {
  private val _uiState = MutableStateFlow(PopularMoviesUiState.Success(emptyList()))
  val uiState: StateFlow<PopularMoviesUiState> = _uiState

  init {
    viewModelScope.launch {
      repository.getPopularMovies().collect { popularMovieList ->
        _uiState.value = PopularMoviesUiState.Success(popularMovieList)
      }
    }
  }
}

sealed class PopularMoviesUiState {
  data class Success(val popularMovieList: List<PopularMovies>) : PopularMoviesUiState()
  data class Error(val errorMessage: String) : PopularMoviesUiState()
}