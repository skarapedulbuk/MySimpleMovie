package com.example.mysimplemovie.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mysimplemovie.R
import com.example.mysimplemovie.model.AppState
import com.example.mysimplemovie.model.repository.Repository
import java.lang.Thread.sleep

class MainViewModel(private val repository: Repository) : ViewModel() {
    private val localLiveData = MutableLiveData<AppState>()
    val liveData: LiveData<AppState> get() = localLiveData

    fun getMovieDetails() = getMovieDetailsFromLocalStorage()

    private fun getMovieDetailsFromLocalStorage() {
        localLiveData.value = AppState.Loading
        Thread {
            sleep(1000)
            if ((0..1).random() == 1) {
                localLiveData.postValue(AppState.Error(Throwable("Expected Error...")))
            } else {
                localLiveData.postValue(AppState.Success(repository.getMovieDetailsFromLocalStorage()))
            }
        }.start()
    }
}