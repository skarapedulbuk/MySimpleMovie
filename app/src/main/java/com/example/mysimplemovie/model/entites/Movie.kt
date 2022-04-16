package com.example.mysimplemovie.model.entites

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val id: Int,
    val title: String
    ):Parcelable
