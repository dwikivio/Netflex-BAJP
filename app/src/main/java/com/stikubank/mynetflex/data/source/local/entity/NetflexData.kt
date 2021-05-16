package com.stikubank.mynetflex.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "netflexentities")
data class NetflexData (
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "netflexId")
    var NetflexId: String,

    @ColumnInfo(name = "type")
    var type: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "synopsis")
    var synopsis: String,

    @ColumnInfo(name = "poster")
    var poster: String,

    @NonNull
    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)