package com.example.mysimplemovie.model

import com.example.mysimplemovie.model.entites.MovieDetails

sealed class AppState {
    data class Success(val movieData: MovieDetails) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}
