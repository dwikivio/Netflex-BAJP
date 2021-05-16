package com.stikubank.mynetflex.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.stikubank.mynetflex.data.source.local.entity.NetflexData

@Database(entities = [NetflexData::class],
    version = 1,
    exportSchema = false)
abstract class NetflexDatabase : RoomDatabase(){

    abstract fun netflexDao(): NetflexDao

}