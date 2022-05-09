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
        val data = repository.getMovieDetailsFromServerById(id)
        if (data.movie.id == 0) {
            localLiveData.postValue(AppState.Error(Throwable("Data loading error, check your VPN !!!")))
        } else {
            Thread {
                localLiveData.postValue(
                    AppState.Success(
                        MoviesList(
                            0,
                            "Fake List For One Movie Details",
                            listOf(data)
                        )
                    )
                )
            }.start()
        }
    }
}

