package com.stikubank.mynetflex.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.stikubank.mynetflex.R
import com.stikubank.mynetflex.data.source.local.entity.NetflexData
import com.stikubank.mynetflex.databinding.ActivityDetailsBinding
import com.stikubank.mynetflex.viewmodel.DetailViewModel
import com.stikubank.mynetflex.vo.Status
import org.koin.android.viewmodel.ext.android.viewModel

class DetailsActivity : AppCompatActivity() {

    private val viewModel: DetailViewModel by viewModel()
    private lateinit var activityDetailsBinding: ActivityDetailsBinding

    companion object {
        const val MOVIE = "NMvID"
        const val SHOWS = "NTvID"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailsBinding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(activityDetailsBinding.root)

        val extra = intent.extras
        val mvID = intent.getStringExtra(MOVIE)
        val tvID = intent.getStringExtra(SHOWS)

        if (extra != null) {
            if (mvID != null) {
                viewModel.setSelectedMovie(mvID)
                viewModel.movie.observe(this, {
                    when (it.status) {
                        Status.LOADING -> activityDetailsBinding.progressBar.visibility =
                            View.VISIBLE
                        Status.SUCCESS -> if (it.data != null) {
                            activityDetailsBinding.progressBar.visibility = View.GONE
                            populateDetail(it.data)
                        }
                        Status.ERROR -> {
                            activityDetailsBinding.progressBar.visibility = View.GONE
                            Toast.makeText(
                                applicationContext,
                                "Something Went Wrong",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                })
            }

            if (tvID != null) {
                viewModel.setSelectedTvShow(tvID)
                viewModel.tvShow.observe(this, {
                    when (it.status) {
                        Status.LOADING -> activityDetailsBinding.progressBar.visibility =
                            View.VISIBLE
                        Status.SUCCESS -> if (it.data != null) {
                            activityDetailsBinding.progressBar.visibility = View.GONE
                            populateDetail(it.data)
                        }
                        Status.ERROR -> {
                            activityDetailsBinding.progressBar.visibility = View.GONE
                            Toast.makeText(
                                applicationContext,
                                "Something Went Wrong",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                })
            }

        }
    }

    private fun populateDetail(netflex: NetflexData) {
        var status = netflex.isFavorite
        activityDetailsBinding.tvJudul.text = netflex.title
        activityDetailsBinding.tvSynopsis.text = netflex.synopsis
        Glide.with(this)
            .load(netflex.poster)
            .into(activityDetailsBinding.ivPoster)

        fun setFavorite(status: Boolean) {
            if (status) {
                activityDetailsBinding.fabFav.setImageDrawable(
                    ContextCompat.getDrawable(this, R.drawable.ic_fav_fill)
                )
            } else {
                activityDetailsBinding.fabFav.setImageDrawable(
                    ContextCompat.getDrawable(this, R.drawable.ic_fav_border)
                )
            }
        }

        setFavorite(status)
        activityDetailsBinding.fabFav.setOnClickListener {
            status = !status
            setFavorite(status)
            viewModel.setFavorite()
        }
    }
}