package com.example.mysimplemovie.model.repository

import com.example.mysimplemovie.model.entites.Movie
import com.example.mysimplemovie.model.entites.MovieDetails
import com.example.mysimplemovie.model.entites.getListOne

class RepositoryImpl: Repository {
    override fun getMovieDetailsFromLocalStorage() = MovieDetails()
    override fun getMoviesListFromLocal(): List<Movie> = getListOne()
}