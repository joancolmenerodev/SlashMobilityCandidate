package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data

import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.model.HttpBinResponse
import retrofit2.http.GET

interface HttpBinService {

    @GET("get")
    suspend fun getHttpBin(): HttpBinResponse

}