package ru.m.kotlin_1.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import ru.m.kotlin_1.R
import ru.m.kotlin_1.databinding.FragmentDetailsBinding
import ru.m.kotlin_1.model.Movie
import ru.m.kotlin_1.viewmodel.AppState
import ru.m.kotlin_1.viewmodel.MainViewModel
import androidx.lifecycle.ViewModelProvider as ViewModelProvider

class MainFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        lifecycle.addObserver(viewModel)

        viewModel.getLiveData().observe(viewLifecycleOwner, { renderData(it) })
        viewModel.getLifeCycleData().observe(viewLifecycleOwner, {
            Snackbar
                    .make(binding.mainView, it, Snackbar.LENGTH_INDEFINITE)
                    .show()
        })
        viewModel.getMovie()


    }

    private fun renderData(appState: AppState) = with(binding) {
        when (appState) {
            is AppState.Success -> {
                val movieData = appState.movieData
                loadingLayout.visibility = View.GONE
                setData(movieData)
            }
            is AppState.Loading -> {
                loadingLayout.visibility = View.VISIBLE
            }
            is AppState.Error -> {
                loadingLayout.visibility = View.GONE
                val error = appState.error
                Snackbar
                        .make(mainView, "Error", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Reload") { viewModel.getMovie() }
                        .show()
            }
        }
    }

    private fun setData(movieData: Movie) = with(binding) {
        titleMovie.text = movieData.film.film
        genre.text = String.format(
                getString(R.string.genre_titile),
                movieData.film.type.toString(),
                movieData.film.genre.toString(),
                movieData.film.year.toInt()
        )
        rankKPValue.text = movieData.rankKP.toString()
        rankIMBdValue.text = movieData.rankIMBd.toString()
    }
}