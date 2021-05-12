package com.stikubank.mynetflex.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse(
    var NetflexId: String,
    var title: String,
    var synopsis: String,
    var poster: String,
): Parcelable