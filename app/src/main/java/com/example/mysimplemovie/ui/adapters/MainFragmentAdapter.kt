package com.example.mysimplemovie.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mysimplemovie.R
import com.example.mysimplemovie.databinding.RecyclerItemBinding
import com.example.mysimplemovie.model.entites.MovieDetails
import com.example.mysimplemovie.showPoster
import com.example.mysimplemovie.ui.main.MainFragment

class MainFragmentAdapter(private val itemClickListener: MainFragment.OnItemViewClickListener) :
    RecyclerView.Adapter<MainFragmentAdapter.MainViewHolder>() {

    private var listOfMovies: List<MovieDetails> = listOf()
    private lateinit var binding: RecyclerItemBinding

    @SuppressLint("NotifyDataSetChanged")
    fun setListOfMovies(data: List<MovieDetails>) {
        listOfMovies = data
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        binding = RecyclerItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MainViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(listOfMovies[position])
    }

    override fun getItemCount() = listOfMovies.size

    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(details: MovieDetails) = with(binding) {
            itemTitleTw.text = details.movie!!.title
            itemPosterImg.showPoster(details.posterPath, 500)
            itemRatingHeaderTw.setText(R.string.rating_space)
            itemRatingTw.text = details.voteAverage.toString()
            root.setOnClickListener { itemClickListener.onItemViewClick(details) }

        }
    }


}