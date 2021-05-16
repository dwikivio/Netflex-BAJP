package com.stikubank.mynetflex.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.stikubank.mynetflex.data.source.local.entity.NetflexData
import com.stikubank.mynetflex.vo.Resource

interface NetflexDataSource {

    fun getAllMovies(): LiveData<Resource<PagedList<NetflexData>>>

    fun getAllTvShows(): LiveData<Resource<PagedList<NetflexData>>>

    fun getMovieById(NMvID: String): LiveData<Resource<NetflexData>>

    fun getTvShowById(NTvID: String) : LiveData<Resource<NetflexData>>

    fun setMovieFav(movie: NetflexData, state: Boolean)

    fun setShowFav(show: NetflexData, state: Boolean)

    fun getFavMovies(): LiveData<PagedList<NetflexData>>

    fun getFavShows(): LiveData<PagedList<NetflexData>>
}