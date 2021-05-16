package com.stikubank.mynetflex.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.stikubank.mynetflex.data.source.local.entity.NetflexData
import com.stikubank.mynetflex.data.source.local.room.NetflexDao

class LocalDataSource(private val mNetflexDao: NetflexDao) {

    companion object{
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(netflexDao: NetflexDao): LocalDataSource = INSTANCE ?: getInstance(netflexDao)
        }

    fun getAllMovies(): DataSource.Factory<Int, NetflexData> = mNetflexDao.getMovies()

    fun getAllTvShows(): DataSource.Factory<Int, NetflexData> = mNetflexDao.getShows()

    fun getMovieById(NMvID: String): LiveData<NetflexData> = mNetflexDao.getDetailData(NMvID)

    fun getTvShowById(NTvID: String) : LiveData<NetflexData> = mNetflexDao.getDetailData(NTvID)

    fun insertData(data: List<NetflexData>) = mNetflexDao.insertData(data)

    fun updateData(data: NetflexData) = mNetflexDao.updateData(data)

    fun setMovieFav(movie: NetflexData, newState: Boolean){
        movie.isFavorite = newState
        mNetflexDao.updateData(movie)
    }

    fun setShowFav(show: NetflexData, newState: Boolean){
        show.isFavorite = newState
        mNetflexDao.updateData(show)
    }

    fun getFavMovies(): DataSource.Factory<Int, NetflexData> = mNetflexDao.getFavMovies()

    fun getFavShows(): DataSource.Factory<Int, NetflexData> = mNetflexDao.getFavShows()


}