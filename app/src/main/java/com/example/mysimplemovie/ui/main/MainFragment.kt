package com.example.mysimplemovie.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.mysimplemovie.*
import com.example.mysimplemovie.databinding.MainFragmentBinding
import com.example.mysimplemovie.model.AppState
import com.example.mysimplemovie.model.entites.MovieDetails
import com.example.mysimplemovie.ui.adapters.MainFragmentAdapter
import com.example.mysimplemovie.ui.details.DetailsFragment
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
            viewModel.getMoviesList()
        }
    }

    private fun renderData(appState: AppState) = with(binding) {
        when (appState) {
            is AppState.Success -> {
                progressBar.hide()
                listNameTw.text = "The idea behind this list is to collect the live action comic book movies from within the Marvel franchise."
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
                    setListOfMovies(appState.movieData)
                }
                mainFragmentRecyclerView.show()
                mainFragmentRecyclerView.adapter = adapter
                mainContainer.showSnackBar(
                    getString(R.string.success),
                    getString(R.string.reload),
                    { viewModel.getMoviesList() })
            }

            is AppState.Loading -> {
                progressBar.show()
            }

            is AppState.Error -> {
                progressBar.hide()
                mainFragmentRecyclerView.hide()
                mainContainer.showSnackBar(
                    appState.error.message.toString(),
                    getString(R.string.reload),
                    { viewModel.getMoviesList() })
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}