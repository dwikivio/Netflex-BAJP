package com.stikubank.mynetflex.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.stikubank.mynetflex.data.NetflexRepository
import com.stikubank.mynetflex.data.source.local.entity.NetflexData
import com.stikubank.mynetflex.vo.Resource

class ShowsViewModel(private val netRepository: NetflexRepository): ViewModel() {

    fun getShows(): LiveData<Resource<PagedList<NetflexData>>> = netRepository.getAllTvShows()

}