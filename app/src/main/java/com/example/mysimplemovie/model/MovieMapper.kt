package com.example.mysimplemovie.model

import com.example.mysimplemovie.model.entites.Movie
import com.example.mysimplemovie.model.entites.MovieDetails
import com.example.mysimplemovie.model.entites.MoviesList
import com.example.mysimplemovie.model.entites.dto.MovieDTO
import com.example.mysimplemovie.model.entites.dto.MoviesListDTO

object MovieMapper {
    fun toValueObject(dto: MoviesListDTO?): List<MovieDetails>? {
        return dto?.items?.map {
            toValueObject(it)
        }

    }

    fun toValueObject(dto: List<MovieDTO>): List<MovieDetails> {
        return dto.map { toValueObject(it) }
    }

    private fun toValueObject(dto: MovieDTO): MovieDetails {
        return MovieDetails(
            movie = Movie(dto.id, dto.title),
            overview = dto.overview,
            voteAverage = dto.voteAverage,
            releaseDate = dto.releaseDate,
            posterPath = dto.posterPath
        )
    }
}