package com.stikubank.mynetflex.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.stikubank.mynetflex.data.NetflexRepository
import com.stikubank.mynetflex.data.source.local.entity.NetflexData
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavMoviesViewModelTest {

    private lateinit var viewModel: FavMoviesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var netflexRepository: NetflexRepository

    @Mock
    private lateinit var observer: Observer<PagedList<NetflexData>>

    @Mock
    private lateinit var pagedList: PagedList<NetflexData>

    @Before
    fun setUp() {
        viewModel = FavMoviesViewModel(netflexRepository)
    }

    @Test
    fun getFavMovies() {
        val dummyMovies = pagedList
        `when`(dummyMovies.size).thenReturn(5)
        val movies = MutableLiveData<PagedList<NetflexData>>()
        movies.value = dummyMovies

        `when`(netflexRepository)
    }
}