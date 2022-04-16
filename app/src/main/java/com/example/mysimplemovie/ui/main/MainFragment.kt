package com.example.mysimplemovie.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.mysimplemovie.R
import com.example.mysimplemovie.databinding.MainFragmentBinding
import com.example.mysimplemovie.model.AppState
import com.example.mysimplemovie.model.entites.MovieDetails
import com.example.mysimplemovie.ui.adapters.MainFragmentAdapter
import com.example.mysimplemovie.ui.details.DetailsFragment
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel // откуда скопировал?

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

            val observer = Observer<AppState> { renderData(it) }
            viewModel.liveData.observe(viewLifecycleOwner, observer)
            viewModel.getMovieDetails()
        }
    }

    private fun renderData(appState: AppState) = with(binding) {
        when (appState) {
            is AppState.Success -> {
                progressBar.visibility = View.GONE
                adapter = MainFragmentAdapter(object : OnItemViewClickListener {
                    override fun onItemViewClick(details: MovieDetails) {
                        val manager = activity?.supportFragmentManager
                        manager?.let { manager ->
                            val bundle = Bundle().apply {
                                putParcelable(DetailsFragment.BUNDLE_EXTRA, details)
                            }
                            manager.beginTransaction()
                                .replace(R.id.container, DetailsFragment.newInstance(bundle))
                                .addToBackStack("")
                                .commitAllowingStateLoss()
                        }
                    }
                }).apply {
                    setDetails(appState.movieData)
                }
                mainFragmentRecyclerView.adapter = adapter
            }

            is AppState.Loading -> {
                progressBar.visibility = View.VISIBLE
            }

            is AppState.Error -> {
                progressBar.visibility = View.GONE


                /*Snackbar
                    .make(mainView, getString(R.string.error), Snackbar.LENGTH_INDEFINITE)
                    .setAction(getString(R.string.reload)) { viewModel.getDetailsFromLocalSource() }
                    .show()*/
            }

        }
        /*when (appState) {
            is AppState.Success -> {
                val movieData = appState.movieData
                progressBar.visibility = View.GONE
                itemGroup.visibility = View.VISIBLE
                setData(movieData)
                Snackbar
                    .make(main, getString(R.string.success), Snackbar.LENGTH_INDEFINITE)
                    .setAction(R.string.reload) { viewModel.getMovieDetails() }
                    .show()
            }
            is AppState.Loading -> {
                itemGroup.visibility = View.INVISIBLE
                progressBar.visibility = View.VISIBLE
            }
            is AppState.Error -> {
                progressBar.visibility = View.GONE
                itemGroup.visibility = View.INVISIBLE
                Snackbar
                    .make(main, appState.error.message.toString(), Snackbar.LENGTH_INDEFINITE)
                    .setAction(R.string.reload) { viewModel.getMovieDetails() }
                    .show()
            }
        }*/
    }

    /*private fun setData(movieData: MovieDetails) = with(binding) {
        itemTextView.text = movieData.movie.title
        itemImage.setImageResource(R.drawable.w200)
    }*/

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}