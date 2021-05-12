package com.stikubank.mynetflex.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.stikubank.mynetflex.data.source.NetflexRepository
import com.stikubank.mynetflex.data.source.local.entity.NetflexData
import com.stikubank.mynetflex.utils.DataDummy

class DetailViewModel(private val netRepository: NetflexRepository): ViewModel() {

    private lateinit var NMvId: String
    private lateinit var NTvId: String

    fun setMovieID(id: String){
        this.NMvId = id
    }

    fun setShowID(id: String){
        this.NTvId = id
    }

    fun getDetailMovie(): LiveData<NetflexData> = netRepository.getMovieById(NMvId)
    fun getDetailShow(): LiveData<NetflexData> = netRepository.getTvShowById(NTvId)

}