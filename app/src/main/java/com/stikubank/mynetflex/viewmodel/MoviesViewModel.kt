package com.stikubank.mynetflex.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.stikubank.mynetflex.data.NetflexRepository
import com.stikubank.mynetflex.data.source.local.entity.NetflexData
import com.stikubank.mynetflex.vo.Resource

class MoviesViewModel(private val netRepository: NetflexRepository): ViewModel() {

    fun getMovies(): LiveData<Resource<PagedList<NetflexData>>> = netRepository.getAllMovies()

}