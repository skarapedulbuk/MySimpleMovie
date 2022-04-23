package com.example.mysimplemovie.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mysimplemovie.*
import com.example.mysimplemovie.databinding.DetailsFragmentBinding
import com.example.mysimplemovie.model.AppState
import com.example.mysimplemovie.model.entites.MovieDetails
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : Fragment() {
    private val viewModel: DetailsViewModel by viewModel()
    private var _binding: DetailsFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<MovieDetails>(BUNDLE_EXTRA)?.let { movieDetailBundle ->
            viewModel.liveData.observe(viewLifecycleOwner) { appState ->
                renderData(appState, movieDetailBundle)
            }
            viewModel.getMovieDetails()
        }
    }

    private fun renderData(appState: AppState, arguments: MovieDetails) = with(binding) {
        when (appState) {
            is AppState.Error -> {
                main.hide()
                progressBar.hide()
                main.showSnackBar(
                    appState.error.message.toString(),
                    getString(R.string.reload),
                    { viewModel.getMovieDetails() })
            }
            is AppState.Loading -> {
                main.hide()
                progressBar.show()
            }
            is AppState.Success -> {
                progressBar.hide()
                main.show()

                titleTw.text = arguments.movie.title
                posterImg.showPoster(arguments.posterPath, 500)
                descriptionTw.text = arguments.overview

                main.showSnackBar(
                    getString(R.string.success),
                    getString(R.string.reload),
                    { viewModel.getMovieDetails() })
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val BUNDLE_EXTRA = "details"

        fun newInstance(bundle: Bundle): DetailsFragment {
            val fragment = DetailsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}
