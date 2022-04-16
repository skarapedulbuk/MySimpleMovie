package com.example.mysimplemovie.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mysimplemovie.R
import com.example.mysimplemovie.databinding.RecyclerItemBinding
import com.example.mysimplemovie.model.entites.MovieDetails
import com.example.mysimplemovie.ui.main.MainFragment

class MainFragmentAdapter(private val itemClickListener: MainFragment.OnItemViewClickListener) :
    RecyclerView.Adapter<MainFragmentAdapter.MainViewHolder>() {

    private var detailsData: List<MovieDetails> = listOf()
    private lateinit var binding: RecyclerItemBinding

    @SuppressLint("NotifyDataSetChanged")
    fun setDetails(data: List<MovieDetails>) {
        detailsData = data
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        binding = RecyclerItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MainViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(detailsData[position])
    }

    override fun getItemCount() = detailsData.size


    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(details: MovieDetails) = with(binding) {
            itemTitleTw.text = details.movie.title
            itemPosterImg.setImageResource(R.drawable.w200)
            itemRatingTw.text = "Рейтинг " + details.voteAverage
            root.setOnClickListener { itemClickListener.onItemViewClick(details) }

        }
    }


}