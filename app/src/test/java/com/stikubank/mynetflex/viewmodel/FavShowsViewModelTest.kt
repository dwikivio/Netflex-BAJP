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
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavShowsViewModelTest {

    private lateinit var viewModel: FavShowsViewModel

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
        viewModel = FavShowsViewModel(netflexRepository)
    }

    @Test
    fun getFavShows() {
        val dummyShows = pagedList
        Mockito.`when`(dummyShows.size).thenReturn(5)
        val shows = MutableLiveData<PagedList<NetflexData>>()
        shows.value = dummyShows

        Mockito.`when`(netflexRepository.getFavShows()).thenReturn(shows)
        val netData = viewModel.getFavShows().value
        Mockito.verify(netflexRepository).getFavShows()
        assertNotNull(netData)
        assertEquals(5, netData?.size)

        viewModel.getFavShows().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyShows)
    }
}