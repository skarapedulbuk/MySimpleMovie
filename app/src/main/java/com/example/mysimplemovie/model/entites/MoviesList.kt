package com.example.mysimplemovie.model.entites

data class MoviesList(
    val id: Int = 1,
    val description: String = "The idea behind this list is to collect the live action comic book movies from within the Marvel franchise.",
    val items: List<MovieDetails> = getList1()
)

/*
object MoviesListFactory{
    fun getLists(count : Int) : List<MoviesList>{
        val parents = mutableListOf<MoviesList>()
        repeat(count){
            val parent = MoviesList(1,
                "The idea behind this list is to collect the live action comic book movies from within the Marvel franchise.",
                getList1())
            parents.add(parent)
        }
        return parents
    }
}*/
