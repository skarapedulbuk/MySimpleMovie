package com.example.mysimplemovie.model.entites.dto

data class MoviesListDTO(
    val id: Int = 0,
    val description: String = "Default Desc of List",
    val items: List<MovieDTO> = emptyList()
)
