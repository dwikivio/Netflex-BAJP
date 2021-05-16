package com.stikubank.mynetflex.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.stikubank.mynetflex.data.NetflexRepository
import com.stikubank.mynetflex.data.source.local.entity.NetflexData
import com.stikubank.mynetflex.vo.Resource

class DetailViewModel(private val netRepository: NetflexRepository): ViewModel() {

//    val detailId = MutableLiveData<String>()
//
//    fun setSelectedItem(detailId: String){
//        this.detailId.value = detailId
//    }
//
//
//
//    fun getDetailMovie(NMvId: String): LiveData<NetflexData> = netRepository.getMovieById(NMvId)
//    fun getDetailShow(NTvId: String): LiveData<NetflexData> = netRepository.getTvShowById(NTvId)
//
//    fun setMovieFav(movie: NetflexData){
//        netRepository.setMovieFav(movie)
//    }
//
//    fun setShowFav(show: NetflexData){
//
//    }

    private var nmvId = MutableLiveData<String>()
    private var ntvId = MutableLiveData<String>()

    var movie: LiveData<Resource<NetflexData>> = Transformations.switchMap(nmvId) {
            NMvId -> netRepository.getMovieById(NMvId)
    }

    var tvShow: LiveData<Resource<NetflexData>> = Transformations.switchMap(ntvId) {
            NTvId -> netRepository.getTvShowById(NTvId)
    }

    fun setSelectedMovie(id: String) {
        this.nmvId.value = id
    }

    fun setSelectedTvShow(id: String) {
        this.ntvId.value = id
    }

    fun setFavorite() {

        val resourceMovie = movie.value
        val resourceTvShow = tvShow.value

        if (resourceMovie != null) {
            val movieData = resourceMovie.data

            if (movieData != null) {
                val newState = !movieData.isFavorite
                netRepository.setMovieFav(movieData, newState)
            }
        }

        if (resourceTvShow != null) {
            val tvShowData = resourceTvShow.data

            if (tvShowData != null) {
                val newState = !tvShowData.isFavorite
                netRepository.setShowFav(tvShowData, newState)
            }
        }
    }

}