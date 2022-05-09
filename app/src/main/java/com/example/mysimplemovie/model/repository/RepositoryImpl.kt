package com.example.mysimplemovie.model.repository

import com.example.mysimplemovie.model.MovieLoader
import com.example.mysimplemovie.model.MovieMapper
import com.example.mysimplemovie.model.entites.Movie
import com.example.mysimplemovie.model.entites.MovieDetails
import com.example.mysimplemovie.model.entites.MoviesList
import com.example.mysimplemovie.model.entites.dto.MoviesListDTO
import com.example.mysimplemovie.model.entites.getList1

class RepositoryImpl : Repository {
    override fun getMoviesListFromLocalStorage() = getList1()

    override fun getMovieDetailsFromServerById(id: Int): List<MovieDetails> {
        val dto = MovieLoader.loadMovieById(id)
        return listOf(
            MovieDetails(
                movie = Movie(id, dto!!.title),
                overview = dto.overview,
                voteAverage = dto.voteAverage,
                releaseDate = dto.releaseDate,
                posterPath = dto.posterPath,
            )
        )
    }

    override fun getMoviesListFromServerLikeObject(id: Int): MoviesList {
        val list = MovieLoader.loadMoviesList(id) ?: MoviesListDTO()
        return MovieMapper.toValueObject(list)
    }
}