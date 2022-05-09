package com.example.mysimplemovie.ui.main

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.mysimplemovie.*
import com.example.mysimplemovie.databinding.MainFragmentBinding
import com.example.mysimplemovie.model.AppState
import com.example.mysimplemovie.model.entites.MovieDetails
import com.example.mysimplemovie.ui.adapters.MainFragmentAdapter
import com.example.mysimplemovie.ui.details.DetailsFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {
    interface OnItemViewClickListener {
        fun onItemViewClick(details: MovieDetails)
    }

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModel()
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!
    private var adapter: MainFragmentAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            mainFragmentRecyclerView.adapter = adapter
            val observer = Observer<AppState> { renderData(it) }
            viewModel.liveData.observe(viewLifecycleOwner, observer)
            //viewModel.getMoviesList(editQuery.text.toString().toInt())
            editQuery.requestFocus()
            searchButton.setOnClickListener {
                viewModel.getMoviesList(
                    editQuery.text.toString().toIntOrNull()
                )
            }
        }
    }

    private fun renderData(appState: AppState) = with(binding) {
        when (appState) {
            is AppState.Success -> {
                progressBar.hide()
                listDescTw.text = appState.moviesList.description
                mainFragmentRecyclerView.show()
                mainFragmentRecyclerView.adapter =
                    MainFragmentAdapter(object : OnItemViewClickListener {
                        override fun onItemViewClick(details: MovieDetails) {
                            detailsFragmentShow(details)
                        }
                    }).apply {
                        setListOfMovies(appState.moviesList.items)
                    }

                Toast.makeText(
                    context,
                    R.string.success,
                    Toast.LENGTH_LONG
                ).show()
            }

            is AppState.Loading -> {
                progressBar.show()
            }

            is AppState.Error -> {
                progressBar.hide()
                mainFragmentRecyclerView.hide()
                listDescTw.text = appState.error.message.toString()

                Toast.makeText(
                    context,
                    appState.error.message.toString(),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    private fun detailsFragmentShow(details: Parcelable) {
        activity?.supportFragmentManager?.let { manager ->
            val bundle = Bundle().apply {
                putParcelable(DetailsFragment.BUNDLE_EXTRA, details)
            }
            manager.beginTransaction()
                .replace(R.id.container, DetailsFragment.newInstance(bundle))
                .addToBackStack("")
                .commitAllowingStateLoss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}