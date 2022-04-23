package com.example.mysimplemovie.model.entites.dto

data class MoviesListDTO(
    val id: Int,
    val description: String,
    val items: List<MovieDTO>
)
