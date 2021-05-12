package com.stikubank.mynetflex.viewmodel.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.stikubank.mynetflex.data.NetflexDataSource
import com.stikubank.mynetflex.data.source.local.entity.NetflexData
import com.stikubank.mynetflex.data.source.remote.RemoteDataSource
import com.stikubank.mynetflex.data.source.remote.response.MovieResponse
import com.stikubank.mynetflex.data.source.remote.response.TvshowResponse

class FakeNetflexRepository(private val remoteDataSource: RemoteDataSource) : NetflexDataSource {

    override fun getAllMovies(): LiveData<List<NetflexData>> {
        val movResult = MutableLiveData<List<NetflexData>>()

        remoteDataSource.getAllMovies(object : RemoteDataSource.movieCallback{
            override fun onAllMovieReceived(movieResponse: List<MovieResponse>){
                val movList = ArrayList<NetflexData>()
                for(response in movieResponse){
                    val mov = NetflexData(
                        response.NetflexId,
                        response.title,
                        response.synopsis,
                        response.poster
                    )
                    movList.add(mov)
                }
                movResult.postValue(movList)
            }
        })
        return movResult
    }

    override fun getAllTvShows(): LiveData<List<NetflexData>> {
        val showResult = MutableLiveData<List<NetflexData>>()
        remoteDataSource.getAllShows(object : RemoteDataSource.showCallback{
            override fun onAllTvshowsReceived(tvShowResponse: List<TvshowResponse>) {
                val showList = ArrayList<NetflexData>()
                for(response in tvShowResponse){
                    val show = NetflexData(
                        response.NetflexId,
                        response.title,
                        response.synopsis,
                        response.poster
                    )
                    showList.add(show)
                }
                showResult.postValue(showList)
            }
        })
        return showResult
    }

    override fun getMovieById(NMvID: String): LiveData<NetflexData> {
        val movieData = MutableLiveData<NetflexData>()
        remoteDataSource.getAllMovies(object : RemoteDataSource.movieCallback{
            override fun onAllMovieReceived(movieResponse: List<MovieResponse>) {
                lateinit var mov: NetflexData
                movieResponse.forEach {
                    if(it.NetflexId == NMvID){
                        mov = NetflexData(
                            it.NetflexId,
                            it.title,
                            it.synopsis,
                            it.poster
                        )
                    }
                }
                movieData.postValue(mov)
            }
        })
        return movieData
    }

    override fun getTvShowById(NTvID: String): LiveData<NetflexData> {
        val showData = MutableLiveData<NetflexData>()
        remoteDataSource.getAllShows(object : RemoteDataSource.showCallback{
            override fun onAllTvshowsReceived(tvShowResponse: List<TvshowResponse>) {
                lateinit var show: NetflexData
                tvShowResponse.forEach {
                    if(it.NetflexId == NTvID){
                        show = NetflexData(
                            it.NetflexId,
                            it.title,
                            it.synopsis,
                            it.poster
                        )
                    }
                }
                showData.postValue(show)
            }
        })
        return showData
    }
}