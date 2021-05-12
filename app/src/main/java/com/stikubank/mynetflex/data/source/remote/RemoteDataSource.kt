package com.stikubank.mynetflex.data.source.remote

import android.os.Handler
import android.os.Looper
import com.stikubank.mynetflex.data.source.remote.response.MovieResponse
import com.stikubank.mynetflex.data.source.remote.response.TvshowResponse
import com.stikubank.mynetflex.utils.EspressoIdlingResource
import com.stikubank.mynetflex.utils.JsonHelper

class RemoteDataSource (private val jsonHelper: JsonHelper) {

    private val handler = Handler(Looper.getMainLooper())

    companion object {

        private const val loadLatency: Long = 1000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource = instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper).apply {
                    instance = this
                }
            }
    }

    fun getAllMovies(callback: movieCallback){
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onAllMovieReceived(jsonHelper.loadMovies())
            EspressoIdlingResource.decrement()
        }, loadLatency)
    }

    fun getAllShows(callback: showCallback){
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onAllTvshowsReceived(jsonHelper.loadShows())
            EspressoIdlingResource.decrement()
        }, loadLatency)
    }

    interface movieCallback {
        fun onAllMovieReceived(movieResponse: List<MovieResponse>)
    }

    interface showCallback {
        fun onAllTvshowsReceived(tvShowResponse: List<TvshowResponse>)
    }

}