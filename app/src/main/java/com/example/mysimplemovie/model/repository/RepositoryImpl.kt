package com.example.mysimplemovie.model.repository

import com.example.mysimplemovie.model.entites.MovieDetails
import com.example.mysimplemovie.model.entites.getList1

class RepositoryImpl: Repository {
    override fun getMovieDetailsFromLocalStorage() = MovieDetails()
    override fun getMoviesList1() = getList1()
}