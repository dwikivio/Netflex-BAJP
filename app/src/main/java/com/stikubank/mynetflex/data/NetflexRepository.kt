package com.stikubank.mynetflex.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.stikubank.mynetflex.data.source.local.LocalDataSource
import com.stikubank.mynetflex.data.source.local.entity.NetflexData
import com.stikubank.mynetflex.data.source.remote.ApiResponse
import com.stikubank.mynetflex.data.source.remote.RemoteDataSource
import com.stikubank.mynetflex.data.source.remote.response.MovieResponse
import com.stikubank.mynetflex.data.source.remote.response.TvshowResponse
import com.stikubank.mynetflex.utils.AppExecutors
import com.stikubank.mynetflex.vo.Resource

class NetflexRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : NetflexDataSource {

    companion object {
        @Volatile
        private var instance: NetflexRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): NetflexRepository =
            instance ?: synchronized(this) {
                instance ?: NetflexRepository(
                    remoteData,
                    localData,
                    appExecutors
                ).apply { instance = this }
            }
    }

    override fun getAllMovies(): LiveData<Resource<PagedList<NetflexData>>> {

        return object :
            NetworkBoundResource<PagedList<NetflexData>, List<MovieResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<NetflexData>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<NetflexData>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovies()

            override fun saveCallResult(data: List<MovieResponse>) {
                val movList = ArrayList<NetflexData>()
                for (response in data) {
                    val mov = NetflexData(
                        response.NetflexId,
                        response.type,
                        response.title,
                        response.synopsis,
                        response.poster
                    )
                    movList.add(mov)
                }
                localDataSource.insertData(movList)
            }
        }.asLiveData()
    }

    override fun getAllTvShows(): LiveData<Resource<PagedList<NetflexData>>> {

        return object :
            NetworkBoundResource<PagedList<NetflexData>, List<TvshowResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<NetflexData>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllTvShows(), config).build()
            }

            override fun shouldFetch(data: PagedList<NetflexData>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<TvshowResponse>>> =
                remoteDataSource.getAllShows()

            override fun saveCallResult(data: List<TvshowResponse>) {
                val showList = ArrayList<NetflexData>()
                for (response in data) {
                    val show = NetflexData(
                        response.NetflexId,
                        response.type,
                        response.title,
                        response.synopsis,
                        response.poster
                    )
                    showList.add(show)
                }
                localDataSource.insertData(showList)
            }
        }.asLiveData()
    }

    override fun getMovieById(NMvID: String): LiveData<Resource<NetflexData>> =
        object : NetworkBoundResource<NetflexData, List<MovieResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<NetflexData> =
                localDataSource.getMovieById(NMvID)

            override fun shouldFetch(data: NetflexData?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovies()

            override fun saveCallResult(data: List<MovieResponse>) {
                val movList = ArrayList<NetflexData>()
                for (response in data) {
                    val mov = NetflexData(
                        response.NetflexId,
                        response.type,
                        response.title,
                        response.synopsis,
                        response.poster
                    )
                    movList.add(mov)
                }
                localDataSource.insertData(movList)
            }
        }.asLiveData()

    override fun getTvShowById(NTvID: String): LiveData<Resource<NetflexData>> =
        object : NetworkBoundResource<NetflexData, List<TvshowResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<NetflexData> =
                localDataSource.getTvShowById(NTvID)

            override fun shouldFetch(data: NetflexData?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<List<TvshowResponse>>> =
                remoteDataSource.getAllShows()

            override fun saveCallResult(data: List<TvshowResponse>) {
                val showList = ArrayList<NetflexData>()
                for (response in data) {
                    val show = NetflexData(
                        response.NetflexId,
                        response.type,
                        response.title,
                        response.synopsis,
                        response.poster
                    )
                    showList.add(show)
                }
                localDataSource.insertData(showList)
            }
        }.asLiveData()

//    override fun getMovieById(NMvID: String): LiveData<NetflexData> = localDataSource.getMovieById(NMvID)
//
//    override fun getTvShowById(NTvID: String): LiveData<NetflexData> = localDataSource.getTvShowById(NTvID)

    override fun setMovieFav(movie: NetflexData, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setMovieFav(movie, state) }

    override fun setShowFav(show: NetflexData, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setShowFav(show, state) }

    override fun getFavMovies(): LiveData<PagedList<NetflexData>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavMovies(), config).build()
    }

    override fun getFavShows(): LiveData<PagedList<NetflexData>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavShows(), config).build()
    }
}