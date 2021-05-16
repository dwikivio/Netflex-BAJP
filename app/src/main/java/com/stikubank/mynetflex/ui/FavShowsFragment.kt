package com.stikubank.mynetflex.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.stikubank.mynetflex.R
import com.stikubank.mynetflex.adapter.FavShowAdapter
import com.stikubank.mynetflex.databinding.FragmentFavShowsBinding
import com.stikubank.mynetflex.viewmodel.FavShowsViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class FavShowsFragment : Fragment() {

    private lateinit var fragmentFavShowsBinding: FragmentFavShowsBinding
    private val vModel: FavShowsViewModel by viewModel()
    private val favShowAdapter = FavShowAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentFavShowsBinding = FragmentFavShowsBinding.inflate(inflater, container, false)
        return fragmentFavShowsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(fragmentFavShowsBinding.rvShows)
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
            fragmentFavShowsBinding.progressBar.visibility = View.VISIBLE
            vModel.getFavShows().observe(this, {
                fragmentFavShowsBinding.progressBar.visibility = View.GONE
//                favShowAdapter.setFavShows(shows)
                favShowAdapter.submitList(it)
                favShowAdapter.notifyDataSetChanged()
            })

            with(fragmentFavShowsBinding.rvShows){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = favShowAdapter
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
            val netflexData = favShowAdapter.getSwipedData(swipedPosition)
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