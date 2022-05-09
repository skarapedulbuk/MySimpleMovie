package com.example.mysimplemovie.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mysimplemovie.model.AppState
import com.example.mysimplemovie.model.entites.MovieDetails
import com.example.mysimplemovie.model.entites.MoviesList
import com.example.mysimplemovie.model.repository.Repository

class DetailsViewModel(private val repository: Repository) : ViewModel() {
    private val localLiveData = MutableLiveData<AppState>()
    val liveData: LiveData<AppState> get() = localLiveData

    fun getMovieDetails(id: Int) = getDetailByID(id)

    private fun getDetailByID(id: Int) {
        localLiveData.value = AppState.Loading
        Thread {
            localLiveData.postValue(
                AppState.Success(
                    MoviesList(
                        0,
                        "Fake List For One Movie Details",
                        repository.getMovieDetailsFromServerById(id)
                    )
                )
            )
        }.start()
    }
}

