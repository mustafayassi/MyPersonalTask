package com.example.mypersonaltask.modle

import com.google.gson.annotations.SerializedName

class TimeLines(
    @SerializedName("timestep")
    val timestep :String?,
    @SerializedName("endTime")
    val endTime :String?,
    @SerializedName("startTime")
    val startTime:String?,
    @SerializedName("intervals")
    val intervals : List<Intervals >?

){
}