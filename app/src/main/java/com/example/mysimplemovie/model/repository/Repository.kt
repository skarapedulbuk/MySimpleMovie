package com.example.mysimplemovie.model.repository

import com.example.mysimplemovie.model.entites.MovieDetails
import com.example.mysimplemovie.model.entites.MoviesList

interface Repository {
//    fun getMoviesListFromLocalStorage(): List<MovieDetails>
    fun getMovieDetailsFromServerById(id: Int): MovieDetails
    fun getMoviesListFromServerLikeObject(id: Int): MoviesList
}