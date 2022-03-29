package com.example.mysimplemovie.ui.main

import com.example.mysimplemovie.model.repository.Repository
import com.example.mysimplemovie.model.repository.RepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<Repository> { RepositoryImpl() }

    // ViewModels
    viewModel { MainViewModel(get()) }
}