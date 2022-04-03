package com.example.mysimplemovie.model.repository

import com.example.mysimplemovie.model.entites.MovieDetails

interface Repository {
    fun getMovieDetailsFromLocalStorage():MovieDetails
    fun getMoviesList1(): List<MovieDetails>
}