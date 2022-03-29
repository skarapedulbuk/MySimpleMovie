package com.example.mysimplemovie.model.repository

import com.example.mysimplemovie.model.entites.MovieDetails

class RepositoryImpl: Repository {
    override fun getMovieDetailsFromLocalStorage() = MovieDetails()
}