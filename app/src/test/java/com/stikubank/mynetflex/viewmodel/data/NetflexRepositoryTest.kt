package com.stikubank.mynetflex.viewmodel.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.verify
import com.stikubank.mynetflex.data.source.remote.RemoteDataSource
import com.stikubank.mynetflex.utils.DataDummy
import com.stikubank.mynetflex.viewmodel.utils.LiveDataTestUtil
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.mockito.Mockito

class NetflexRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val netflexRepository = FakeNetflexRepository(remote)

    private val movieResponse = DataDummy.generateRemoteDummyMovies()
    private val movId = movieResponse[0].NetflexId
    private val showResponse = DataDummy.generateRemoteDummyShows()
    private val showId = showResponse[0].NetflexId

    @Test
    fun getAllMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.movieCallback)
                    .onAllMovieReceived(movieResponse)
            null
        }.`when`(remote).getAllMovies(any())
        val movEntity = LiveDataTestUtil.getValue(netflexRepository.getAllMovies())
        verify(remote).getAllMovies(any())
        assertNotNull(movEntity)
        assertEquals(movieResponse.size.toLong(), movEntity.size.toLong())
    }

    @Test
    fun getAllTvShows() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.showCallback)
                    .onAllTvshowsReceived(showResponse)
            null
        }.`when`(remote).getAllShows(any())
        val showEntity = LiveDataTestUtil.getValue(netflexRepository.getAllTvShows())
        verify(remote).getAllShows(any())
        assertNotNull(showEntity)
        assertEquals(showResponse.size.toLong(), showEntity.size.toLong())
    }

    @Test
    fun getMovieById() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.movieCallback)
                    .onAllMovieReceived(movieResponse)
            null
        }.`when`(remote).getAllMovies(any())

        val movieEntity = LiveDataTestUtil.getValue(netflexRepository.getMovieById(movId))

        verify(remote).getAllMovies(any())

        assertNotNull(movieEntity)
        assertNotNull(movieEntity.title)
        assertEquals(movieResponse[0].title, movieEntity.title)
    }

    @Test
    fun getTvShowById() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.showCallback)
                    .onAllTvshowsReceived(showResponse)
            null
        }.`when`(remote).getAllShows(any())

        val showEntity = LiveDataTestUtil.getValue(netflexRepository.getTvShowById(showId))

        verify(remote).getAllShows(any())

        assertNotNull(showEntity)
        assertNotNull(showEntity.title)
        assertEquals(showResponse[0].title, showEntity.title)
    }
}