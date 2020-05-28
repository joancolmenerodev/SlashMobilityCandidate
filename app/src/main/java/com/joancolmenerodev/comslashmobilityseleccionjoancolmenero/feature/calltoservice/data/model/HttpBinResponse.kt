package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.model


import com.google.gson.annotations.SerializedName

data class HttpBinResponse(
    @SerializedName("args")
    val args: ArgsDTO,
    @SerializedName("headers")
    val headers: HeadersDTO,
    @SerializedName("origin")
    val origin: String,
    @SerializedName("url")
    val url: String
)