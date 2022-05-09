package com.example.mysimplemovie.model.entites.dto

import com.google.gson.annotations.SerializedName

data class MovieDTO(
    val id: Int = 0,
    val title: String = "Default Title",
    val overview: String = "Default Overview",
    @SerializedName("vote_average") val voteAverage: Number = 0.0,
    @SerializedName("release_date") val releaseDate: String = "0000-00-00",
    @SerializedName("poster_path") val posterPath: String = "/zpH4yEqOJOReykVcSQYA1A258SQ.jpg"
)
