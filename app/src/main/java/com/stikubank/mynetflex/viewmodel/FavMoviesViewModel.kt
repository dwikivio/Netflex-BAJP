package com.stikubank.mynetflex.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.stikubank.mynetflex.data.NetflexRepository
import com.stikubank.mynetflex.data.source.local.entity.NetflexData

class FavMoviesViewModel(private val netRepository: NetflexRepository): ViewModel() {

    fun getFavMovies(): LiveData<PagedList<NetflexData>> = netRepository.getFavMovies()

    fun setFav(movie: NetflexData){
        val newState = !movie.isFavorite
        netRepository.setMovieFav(movie, newState)
    }
}