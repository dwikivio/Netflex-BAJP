package com.stikubank.mynetflex.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.stikubank.mynetflex.R
import com.stikubank.mynetflex.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.activity_details.*
import org.koin.android.viewmodel.ext.android.viewModel

class DetailsActivity : AppCompatActivity() {

    private val viewModel: DetailViewModel by viewModel()

    companion object{
        const val MOVIE = "NMvID"
        const val SHOWS = "NTvID"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

            val mvID = intent.getStringExtra(MOVIE)
            val tvID = intent.getStringExtra(SHOWS)
            mvID?.let{
                populateMovieDetail(mvID)
            }

            tvID?.let {
                populateTvDetail(tvID)
            }

    }

    private fun populateMovieDetail(mvId: String){
        progress_bar.visibility = View.VISIBLE
        viewModel.setMovieID(mvId)
        viewModel.getDetailMovie().observe(this,{
            progress_bar.visibility = View.GONE
            tv_judul.text = it.title
            tv_synopsis.text = it.synopsis
            Glide.with(iv_poster)
                    .load(it.poster)
                    .into(iv_poster)
        })
    }

    private fun populateTvDetail(tvId: String){
        progress_bar.visibility = View.VISIBLE
        viewModel.setShowID(tvId)
        viewModel.getDetailShow().observe(this, {
            progress_bar.visibility = View.GONE
            tv_judul.text = it.title
            tv_synopsis.text = it.synopsis
            Glide.with(iv_poster)
                    .load(it.poster)
                    .into(iv_poster)
        })
    }
}