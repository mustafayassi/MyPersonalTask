package com.example.mypersonaltask.modle

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("data")
    val data:Data?
)
