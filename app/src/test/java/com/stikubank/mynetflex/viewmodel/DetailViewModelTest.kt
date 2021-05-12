package com.stikubank.mynetflex.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.stikubank.mynetflex.data.source.NetflexRepository
import com.stikubank.mynetflex.data.source.local.entity.NetflexData
import com.stikubank.mynetflex.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
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
    private lateinit var observer: Observer<NetflexData>

    @Before
    fun setUp(){
        viewModel = DetailViewModel(netflexRepository)
        viewModel.setMovieID(NMvId)
        viewModel.setShowID(NTvId)
    }

    @Test
    fun getDetailMovie() {
        val movies = MutableLiveData<NetflexData>()
        movies.value = dataMovies

        `when`(netflexRepository.getMovieById(NMvId)).thenReturn(movies)
        val detailMovie = viewModel.getDetailMovie().value as NetflexData
        verify(netflexRepository).getMovieById(NMvId)

        assertNotNull(detailMovie)
        assertEquals(dataMovies.NetflexId, detailMovie.NetflexId)
        assertEquals(dataMovies.title, detailMovie.title)
        assertEquals(dataMovies.synopsis, detailMovie.synopsis)
        assertEquals(dataMovies.poster, detailMovie.poster)

        viewModel.getDetailMovie().observeForever(observer)
        verify(observer).onChanged(dataMovies)
    }

    @Test
    fun getDetailShow() {
        val shows = MutableLiveData<NetflexData>()
        shows.value = dataTvshow

        `when`(netflexRepository.getTvShowById(NTvId)).thenReturn(shows)
        val detailShow = viewModel.getDetailShow().value as NetflexData
        verify(netflexRepository).getTvShowById(NTvId)

        assertNotNull(detailShow)
        assertEquals(dataTvshow.NetflexId, detailShow.NetflexId)
        assertEquals(dataTvshow.title, detailShow.title)
        assertEquals(dataTvshow.synopsis, detailShow.synopsis)
        assertEquals(dataTvshow.poster, detailShow.poster)

        viewModel.getDetailShow().observeForever(observer)
        verify(observer).onChanged(dataTvshow)
    }
}