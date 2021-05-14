package com.stikubank.mynetflex.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.stikubank.mynetflex.data.source.local.entity.NetflexData

@Dao
interface NetflexDao {

    @Query("SELECT * FROM netflexentities")
    fun getMovies(): LiveData<List<NetflexData>>

    @Query("SELECT * FROM netflexentities")
    fun getShows(): LiveData<List<NetflexData>>

    @Query("SELECT * FROM netflexentities WHERE netflexId = :netflexId")
    fun getDetailData(netflexId: String) : LiveData<NetflexData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(courses: List<NetflexData>)

    @Update(entity = NetflexData::class)
    fun updateData(data : NetflexData)
}