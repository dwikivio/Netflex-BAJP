package com.stikubank.mynetflex.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
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
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ShowsViewModelTest {

    private lateinit var viewModel: ShowsViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var netflexRepository: NetflexRepository

    @Mock
    private lateinit var observer: Observer<List<NetflexData>>

    @Before
    fun setUp(){
        viewModel = ShowsViewModel(netflexRepository)
    }

    @Test
    fun getShows() {
        val dummyShows = DataDummy.generateTvShows()
        val shows = MutableLiveData<List<NetflexData>>()
        shows.value = dummyShows

        `when`(netflexRepository.getAllTvShows()).thenReturn(shows)
        val netData = viewModel.getShows().value
        verify(netflexRepository).getAllTvShows()
        assertNotNull(netData)
        assertEquals(10,netData?.size)

        viewModel.getShows().observeForever(observer)
        verify(observer).onChanged(dummyShows)
    }
}