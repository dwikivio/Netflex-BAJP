package com.stikubank.mynetflex.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.stikubank.mynetflex.data.NetflexRepository
import com.stikubank.mynetflex.data.source.local.entity.NetflexData
import com.stikubank.mynetflex.utils.DataDummy
import com.stikubank.mynetflex.vo.Resource
import org.junit.Test

import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dataMovies = DataDummy.generateMovies()[0]
    private val dataTvshow = DataDummy.generateTvShows()[0]

    private val NMvId = dataMovies.NetflexId
    private val NTvId = dataTvshow.NetflexId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var netflexRepository: NetflexRepository

    @Mock
    private lateinit var observer: Observer<Resource<NetflexData>>

    @Before
    fun setUp(){
        viewModel = DetailViewModel(netflexRepository)
        viewModel.setSelectedMovie(NMvId)
        viewModel.setSelectedTvShow(NTvId)
    }

    @Test
    fun getDetailMovie() {
        val dummyDetailMovies = Resource.success(DataDummy.generateMovies()[0])
        val movies = MutableLiveData<Resource<NetflexData>>()
        movies.value = dummyDetailMovies

        `when`(netflexRepository.getMovieById(NMvId)).thenReturn(movies)
        viewModel.movie.observeForever(observer)
        verify(observer).onChanged(dummyDetailMovies)
    }

    @Test
    fun getDetailShow() {
        val dummyDetailShows = Resource.success(DataDummy.generateTvShows()[0])
        val shows = MutableLiveData<Resource<NetflexData>>()
        shows.value = dummyDetailShows

        `when`(netflexRepository.getTvShowById(NTvId)).thenReturn(shows)
        viewModel.tvShow.observeForever(observer)
        verify(observer).onChanged(dummyDetailShows)
    }
}