package com.stikubank.mynetflex.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.stikubank.mynetflex.R
import com.stikubank.mynetflex.adapter.FavMovieAdapter
import com.stikubank.mynetflex.databinding.FragmentFavMoviesBinding
import com.stikubank.mynetflex.viewmodel.FavMoviesViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class FavMoviesFragment : Fragment() {

    private lateinit var fragmentFavMoviesBinding: FragmentFavMoviesBinding
    private val favMovieAdapter = FavMovieAdapter()
    private val vModel: FavMoviesViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentFavMoviesBinding = FragmentFavMoviesBinding.inflate(inflater, container, false)
        return fragmentFavMoviesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(fragmentFavMoviesBinding.rvMovies)
        if(activity != null){

//            vModel.getMovies().observe(this, { movies ->
//                if(movies != null ){
//                    when(movies.status){
//                        Status.LOADING -> fragmentFavMoviesBinding?.progressBar?.visibility = View.VISIBLE
//                        Status.SUCCESS -> {
//                            fragmentFavMoviesBinding?.progressBar?.visibility = View.GONE
//                            movieAdapter.setMovies(movies.data)
//                            movieAdapter.notifyDataSetChanged()
//                        }
//                        Status.ERROR -> {
//                            fragmentFavMoviesBinding?.progressBar?.visibility = View.GONE
//                            Toast.makeText(context, "Something Went Wrong", Toast.LENGTH_SHORT).show()
//                        }
//                    }
//                }
//            })
//
//            with(fragmentMoviesBinding?.rvMovies){
//                this?.layoutManager = LinearLayoutManager(context)
//                this?.setHasFixedSize(true)
//                this?.adapter = movieAdapter
//            }
            fragmentFavMoviesBinding.progressBar.visibility = View.VISIBLE
            vModel.getFavMovies().observe(this, {
                fragmentFavMoviesBinding.progressBar.visibility = View.GONE
//                favMovieAdapter.setFavMovies(movies)
                favMovieAdapter.submitList(it)
                favMovieAdapter.notifyDataSetChanged()
            })

            with(fragmentFavMoviesBinding.rvMovies){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = favMovieAdapter
            }

        }
    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        fragmentFavMoviesBinding = null
//    }
    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int =
            makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean = true
        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val netflexData = favMovieAdapter.getSwipedData(swipedPosition)
                netflexData?.let { vModel.setFav(it) }
                val snackbar = Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.message_ok) { _ ->
                    netflexData?.let { vModel.setFav(it) }
                }
                snackbar.show()
            }
        }
    })
}