package com.stikubank.mynetflex.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.stikubank.mynetflex.data.source.local.entity.NetflexData

@Dao
interface NetflexDao {

    @Query("SELECT * FROM netflexentities WHERE type = 'movie'")
    fun getMovies(): DataSource.Factory<Int, NetflexData>

    @Query("SELECT * FROM netflexentities WHERE type = 'tvshow'")
    fun getShows(): DataSource.Factory<Int, NetflexData>

    @Query("SELECT * FROM netflexentities WHERE netflexId = :netflexId")
    fun getDetailData(netflexId: String) : LiveData<NetflexData>

    @Query("SELECT * FROM netflexentities WHERE type = 'movie' AND isFavorite = 1")
    fun getFavMovies() : DataSource.Factory<Int, NetflexData>

    @Query("SELECT * FROM netflexentities WHERE type = 'tvshow' AND isFavorite = 1")
    fun getFavShows() : DataSource.Factory<Int, NetflexData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(courses: List<NetflexData>)

    @Update(entity = NetflexData::class)
    fun updateData(data : NetflexData)
}