package com.example.mysimplemovie.model

import com.example.mysimplemovie.model.entites.MoviesList

sealed class AppState {
    data class Success(val moviesList: MoviesList) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}
