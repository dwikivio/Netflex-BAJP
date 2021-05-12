package com.stikubank.mynetflex.data

import androidx.lifecycle.LiveData
import com.stikubank.mynetflex.data.source.local.entity.NetflexData

interface NetflexDataSource {

    fun getAllMovies(): LiveData<List<NetflexData>>

    fun getAllTvShows(): LiveData<List<NetflexData>>

    fun getMovieById(NMvID: String): LiveData<NetflexData>

    fun getTvShowById(NTvID: String) : LiveData<NetflexData>
}