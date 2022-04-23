package com.example.mysimplemovie.model.repository

import com.example.mysimplemovie.model.entites.getList1

class RepositoryImpl: Repository {
    override fun getMoviesListFromLocalStorage() = getList1()
}