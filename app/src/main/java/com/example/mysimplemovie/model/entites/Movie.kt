package com.example.mysimplemovie.model.entites

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val title: String
    ):Parcelable
