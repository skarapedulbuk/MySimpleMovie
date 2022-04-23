package com.example.mysimplemovie.model.repository

import com.example.mysimplemovie.model.entites.MovieDetails
import com.example.mysimplemovie.model.entites.MoviesList
import com.example.mysimplemovie.model.entites.dto.MoviesListDTO

interface Repository {
    fun getMoviesListFromLocalStorage():List<MovieDetails>
    fun getMovieDetailsFromServerById(id: Int):List<MovieDetails>
    fun getMoviesListFromServerById(id: Int): List<MovieDetails>?
}