package com.stikubank.mynetflex.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.stikubank.mynetflex.data.NetflexRepository
import com.stikubank.mynetflex.data.source.local.entity.NetflexData
import com.stikubank.mynetflex.vo.Resource
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
class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var netflexRepository: NetflexRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<NetflexData>>>

    @Mock
    private lateinit var pagedList: PagedList<NetflexData>

    @Before
    fun setUp(){
        viewModel = MoviesViewModel(netflexRepository)
    }

    @Test
    fun getMovies() {
        val dummyMovies = Resource.success(pagedList)
        `when`(dummyMovies.data?.size).thenReturn(10)
        val movies = MutableLiveData<Resource<PagedList<NetflexData>>>()
        movies.value = dummyMovies

        `when`(netflexRepository.getAllMovies()).thenReturn(movies)
        val netData = viewModel.getMovies().value?.data
        verify(netflexRepository).getAllMovies()
        assertNotNull(netData)
        assertEquals(10, netData?.size)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}