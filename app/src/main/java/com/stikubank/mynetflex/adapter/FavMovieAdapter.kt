package com.stikubank.mynetflex.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.stikubank.mynetflex.data.source.local.entity.NetflexData
import com.stikubank.mynetflex.databinding.ItemsMovieBinding
import com.stikubank.mynetflex.ui.DetailsActivity

class FavMovieAdapter: PagedListAdapter<NetflexData, FavMovieAdapter.FavMovieViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<NetflexData>() {
            override fun areItemsTheSame(oldItem: NetflexData, newItem: NetflexData): Boolean {
                return oldItem.NetflexId == newItem.NetflexId
            }
            override fun areContentsTheSame(oldItem: NetflexData, newItem: NetflexData): Boolean {
                return oldItem == newItem
            }
        }
    }

    fun getSwipedData(swipedPosition: Int): NetflexData? = getItem(swipedPosition)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavMovieAdapter.FavMovieViewHolder {
        val itemsMoviesBinding = ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavMovieViewHolder(itemsMoviesBinding)
    }

    override fun onBindViewHolder(holder: FavMovieViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            holder.bind(movie)
        }
    }

    inner class FavMovieViewHolder(private val binding: ItemsMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: NetflexData){
            with(binding){
                tvItem.text = movie.title
                Glide.with(itemView.context)
                    .load(movie.poster)
                    .into(ivPoster)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailsActivity::class.java)
                    intent.putExtra(DetailsActivity.MOVIE, movie.NetflexId)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

}