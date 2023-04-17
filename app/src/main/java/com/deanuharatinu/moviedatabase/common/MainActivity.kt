package com.deanuharatinu.moviedatabase.common

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.deanuharatinu.moviedatabase.popularmovies.presentation.PopularMovieView
import com.deanuharatinu.moviedatabase.ui.theme.MovieDatabaseTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MovieDatabaseTheme {
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colors.background
        ) {

          Scaffold(topBar = { AppBar() }) { paddingValues ->
            PopularMovieView(modifier = Modifier.padding(paddingValues))
          }
        }
      }
    }
  }
}


@Composable
fun AppBar() {
  TopAppBar(
    title = {
      Text(
        text = "Movie Database",
        color = Color.White,
      )
    },
    backgroundColor = MaterialTheme.colors.primaryVariant
  )
}