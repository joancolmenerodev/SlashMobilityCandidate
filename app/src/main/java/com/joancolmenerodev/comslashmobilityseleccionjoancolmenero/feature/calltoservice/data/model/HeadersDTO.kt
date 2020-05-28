package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.model


import com.google.gson.annotations.SerializedName

data class HeadersDTO(
    @SerializedName("Accept")
    val accept: String,
    @SerializedName("Host")
    val host: String,
    @SerializedName("User-Agent")
    val userAgent: String,
    @SerializedName("X-Amzn-Trace-Id")
    val xAmznTraceId: String,
    @SerializedName("X-Cmc-Pro-Api-Key")
    val xCmcProApiKey: String
)