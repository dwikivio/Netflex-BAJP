package com.stikubank.mynetflex.viewmodel.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.DataSource
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.verify
import com.stikubank.mynetflex.data.source.local.LocalDataSource
import com.stikubank.mynetflex.data.source.local.entity.NetflexData
import com.stikubank.mynetflex.data.source.remote.RemoteDataSource
import com.stikubank.mynetflex.utils.AppExecutors
import com.stikubank.mynetflex.utils.DataDummy
import com.stikubank.mynetflex.viewmodel.utils.LiveDataTestUtil
import com.stikubank.mynetflex.viewmodel.utils.PagedListUtil
import com.stikubank.mynetflex.vo.Resource
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class NetflexRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val netflexRepository = FakeNetflexRepository(remote, local, appExecutors)

    private val movieResponse = DataDummy.generateRemoteDummyMovies()
    private val showResponse = DataDummy.generateRemoteDummyShows()

    @Test
    fun getAllMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, NetflexData>
        `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        netflexRepository.getAllMovies()

        val movEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateMovies()))
        verify(local).getAllMovies()
        assertNotNull(movEntity)
        assertEquals(movieResponse.size.toLong(), movEntity.data?.size?.toLong())
    }

    fun getFavMovies(){
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, NetflexData>
        `when`(local.getFavMovies()).thenReturn(dataSourceFactory)
        netflexRepository.getFavMovies()

        val favMovieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateMovies()))
        verify(local).getFavMovies()
        assertNotNull(favMovieEntities)
        assertEquals(movieResponse.size.toLong(), favMovieEntities.data?.size?.toLong())
    }

    @Test
    fun getAllTvShows() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, NetflexData>
        `when`(local.getAllTvShows()).thenReturn(dataSourceFactory)
        netflexRepository.getAllTvShows()

        val showEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateTvShows()))
        verify(local).getAllTvShows()
        assertNotNull(showEntity)
        assertEquals(showResponse.size.toLong(), showEntity.data?.size?.toLong())
    }

    fun getFavShows(){
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, NetflexData>
        `when`(local.getFavShows()).thenReturn(dataSourceFactory)
        netflexRepository.getFavShows()

        val favShowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateTvShows()))
        verify(local).getFavShows()
        assertNotNull(favShowEntities)
        assertEquals(showResponse.size.toLong(), favShowEntities.data?.size?.toLong())
    }

}