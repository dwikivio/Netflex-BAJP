package com.stikubank.mynetflex.utils

import android.content.Context
import com.stikubank.mynetflex.data.source.remote.response.MovieResponse
import com.stikubank.mynetflex.data.source.remote.response.TvshowResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("MovieData").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val nmvid = movie.getString("NMvID")
                val type = movie.getString("type")
                val title = movie.getString("title")
                val synop = movie.getString("synopsis")
                val poster = movie.getString("poster")

                val movieResponse = MovieResponse(nmvid, type, title, synop, poster)
                list.add(movieResponse)

                println(list)
                println("ini tanda loadmovies")
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

    fun loadShows(): List<TvshowResponse> {
        val list = ArrayList<TvshowResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("TvshowData").toString())
            val listArray = responseObject.getJSONArray("tvshow")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val ntvid = movie.getString("NTvID")
                val type = movie.getString("type")
                val title = movie.getString("title")
                val synop = movie.getString("synopsis")
                val poster = movie.getString("poster")

                val showResponse = TvshowResponse(ntvid, type, title, synop, poster)
                list.add(showResponse)

                println(list)
                println("ini tanda loadshow")
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

}