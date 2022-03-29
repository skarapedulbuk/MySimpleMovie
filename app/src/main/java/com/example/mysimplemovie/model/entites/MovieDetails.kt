package com.example.mysimplemovie.model.entites

data class MovieDetails(
    val movie: Movie = getDefaultMovie(),
    val overview: String = "Default Overview",
    val voteAverage: Double = 0.0,
    val releaseDate: String = "2000-01-01"
)

fun getDefaultMovie() = Movie("Title Default")
