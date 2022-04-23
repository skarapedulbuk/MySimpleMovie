package com.example.mysimplemovie.model.entites.dto

import com.google.gson.annotations.SerializedName

data class MovieDTO(
    val id: Int?,
    val title: String?,
    val overview: String?,
    @SerializedName("vote_average") val voteAverage: Number?,
    @SerializedName("release_date") val releaseDate: String?,
    @SerializedName("poster_path") val posterPath: String?
)
