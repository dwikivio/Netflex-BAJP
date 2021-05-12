package com.stikubank.mynetflex.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.stikubank.mynetflex.data.source.NetflexRepository
import com.stikubank.mynetflex.data.source.local.entity.NetflexData
import com.stikubank.mynetflex.utils.DataDummy

class MoviesViewModel(private val netRepository: NetflexRepository): ViewModel() {

    fun getMovies(): LiveData<List<NetflexData>> = netRepository.getAllMovies()

}