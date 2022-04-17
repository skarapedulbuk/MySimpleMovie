package com.example.mysimplemovie

import android.view.View
import android.widget.ImageView
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

fun View.showSnackBar(
    text: String,
    actionText: String,
    action: (View) -> Unit,
    length: Int = Snackbar.LENGTH_SHORT
) {
    Snackbar.make(this, text, length).setAction(actionText, action).show()
}

fun ImageView.showPoster(posterPath: String, size: Int) {
    Picasso.get().load("https://image.tmdb.org/t/p/w${size}${posterPath}")
        .into(this)
}

fun View.show() : View {
    if (visibility != View.VISIBLE) {
        visibility = View.VISIBLE
    }
    return this
}
fun View.hide() : View {
    if (visibility != View.GONE) {
        visibility = View.GONE
    }
    return this
}
