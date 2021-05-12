package com.stikubank.mynetflex.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.stikubank.mynetflex.adapter.MovieAdapter
import com.stikubank.mynetflex.databinding.FragmentMoviesBinding
import com.stikubank.mynetflex.viewmodel.MoviesViewModel
import com.stikubank.mynetflex.viewmodel.ViewModelFactory

class MoviesFragment : Fragment() {

    private lateinit var fragmentMoviesBinding: FragmentMoviesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentMoviesBinding = FragmentMoviesBinding.inflate(inflater, container, false)
        return fragmentMoviesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null){

            val factory = ViewModelFactory.getInstance(requireActivity())
            val vModel = ViewModelProvider(this, factory)[MoviesViewModel::class.java]

            val movieAdapter = MovieAdapter()

            fragmentMoviesBinding.progressBar.visibility = View.VISIBLE
            vModel.getMovies().observe(this, { movies ->
                fragmentMoviesBinding.progressBar.visibility = View.GONE
                movieAdapter.setMovies(movies)
                movieAdapter.notifyDataSetChanged()
            })

            with(fragmentMoviesBinding.rvMovies){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }

}