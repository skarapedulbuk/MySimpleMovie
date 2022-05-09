package com.example.mysimplemovie.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mysimplemovie.model.AppState
import com.example.mysimplemovie.model.repository.Repository

class MainViewModel(private val repository: Repository) : ViewModel() {
    private val localLiveData = MutableLiveData<AppState>()
    val liveData: LiveData<AppState> get() = localLiveData

    fun getMoviesList(id: Int) = getMoviesListFromServer(id)

    private fun getMoviesListFromServer(id: Int) {
        localLiveData.value = AppState.Loading
        Thread {
            val list = repository.getMoviesListFromServerLikeObject(id)
            localLiveData.postValue(AppState.Success(list))
        }.start()
    }
}