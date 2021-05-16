package com.stikubank.mynetflex.ui

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.stikubank.mynetflex.R
import com.stikubank.mynetflex.adapter.MovieAdapter
import com.stikubank.mynetflex.databinding.FragmentMoviesBinding
import com.stikubank.mynetflex.viewmodel.MoviesViewModel
import com.stikubank.mynetflex.vo.Status
import org.koin.android.viewmodel.ext.android.viewModel

class MoviesFragment : Fragment() {

    private var fragmentMoviesBinding: FragmentMoviesBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentMoviesBinding = FragmentMoviesBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return fragmentMoviesBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null){
            val vModel: MoviesViewModel by viewModel()
            val movieAdapter = MovieAdapter()

            vModel.getMovies().observe(this, { movies ->
                if(movies != null ){
                    when(movies.status){
                        Status.LOADING -> fragmentMoviesBinding?.progressBar?.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            fragmentMoviesBinding?.progressBar?.visibility = View.GONE
                            movieAdapter.submitList(movies.data)
                            movieAdapter.notifyDataSetChanged()
                        }
                        Status.ERROR -> {
                            fragmentMoviesBinding?.progressBar?.visibility = View.GONE
                            Toast.makeText(context, "Something Went Wrong", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(fragmentMoviesBinding?.rvMovies){
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = movieAdapter
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_favorite, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
                R.id.menu_favorite -> startActivity(Intent(requireContext(), FavoriteActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentMoviesBinding = null
    }
}