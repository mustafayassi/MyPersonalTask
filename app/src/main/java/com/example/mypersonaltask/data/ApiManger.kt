package com.example.mypersonaltask.data

import android.util.Log
import com.example.mypersonaltask.modle.WeatherResponse
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

object ApiManger {
    private val client = OkHttpClient()
    private const val baseUrl = "https://api.tomorrow.io/v4/"
    private val gson = Gson()

    fun makeRequestUsingOkhttp(function: (response: WeatherResponse) -> Unit) {

        val client = OkHttpClient()
        val gson = Gson()
        val url = HttpUrl.Builder()
            .scheme("https")
            .host("api.tomorrow.io")
            .addPathSegments("v4/timelines")
            .addQueryParameter("location", "33.2209,43.6848")
            .addQueryParameter("fields", "temperature")
            .addQueryParameter("timesteps", "1h")
            .addQueryParameter("units", "metric")
            .addQueryParameter("startTime", "now")
            .addQueryParameter("endTime", "nowPlus6h")
            .addQueryParameter("apikey", "C7RR2W4xja6KxBSjET0kn3wBdz6QJ4TZ")
            .build()

        val request = Request.Builder().url(url).build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.i("LOG_TAG", "Fail ${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                response.body?.string()?.let {jsonString ->
                    val result = gson.fromJson(jsonString, WeatherResponse::class.java)
                    function(result)
                    Log.i("LOG_TAG", "PLEASE NO PLEASE ${result.data?.timelines?.get(0)?.intervals?.get(0)?.values?.temperature}")
                }

            }

        })
    }
}