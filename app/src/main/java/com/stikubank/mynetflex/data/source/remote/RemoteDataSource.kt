package com.stikubank.mynetflex.data.source.remote

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    fun getAllMovies(): LiveData<ApiResponse<List<MovieResponse>>>{
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        handler.postDelayed({
            resultMovie.value = ApiResponse.success(jsonHelper.loadMovies())
//            callback.onAllMovieReceived(jsonHelper.loadMovies())
            EspressoIdlingResource.decrement()
        }, loadLatency)
        return resultMovie
    }

    fun getAllShows(): LiveData<ApiResponse<List<TvshowResponse>>>{
        EspressoIdlingResource.increment()
        val resultShow = MutableLiveData<ApiResponse<List<TvshowResponse>>>()
        handler.postDelayed({
            resultShow.value = ApiResponse.success(jsonHelper.loadShows())
//            callback.onAllTvshowsReceived(jsonHelper.loadShows())
            EspressoIdlingResource.decrement()
        }, loadLatency)
        return resultShow
    }

//    interface movieCallback {
//        fun onAllMovieReceived(movieResponse: List<MovieResponse>)
//    }
//
//    interface showCallback {
//        fun onAllTvshowsReceived(tvShowResponse: List<TvshowResponse>)
//    }

}