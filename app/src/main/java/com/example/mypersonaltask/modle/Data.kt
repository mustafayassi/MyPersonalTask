package com.example.mypersonaltask.modle

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("timelines")
    val timelines :List <TimeLines>
)

