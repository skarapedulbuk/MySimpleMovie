package com.example.mysimplemovie.model.entites.dto

import com.example.mysimplemovie.model.entites.getList1

data class MoviesListDTO(
    val id: Int = 0,
    val description: String = "Default Desc of List",
    val items: List<MovieDTO> = getListDTO()
)
fun getListDTO(): List<MovieDTO> {
    return listOf(MovieDTO(), MovieDTO())
}

