package com.stikubank.mynetflex.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.stikubank.mynetflex.data.NetflexRepository
import com.stikubank.mynetflex.data.source.local.entity.NetflexData

class FavShowsViewModel (private val netRepository: NetflexRepository): ViewModel() {
    fun getFavShows(): LiveData<PagedList<NetflexData>> = netRepository.getFavShows()

    fun setFav(show: NetflexData){
        val newState = !show.isFavorite
        netRepository.setShowFav(show, newState)
    }
}