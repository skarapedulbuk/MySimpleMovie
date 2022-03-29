package com.example.mysimplemovie.ui.main

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
// ViewModels
    viewModel { MainViewModel() }
}