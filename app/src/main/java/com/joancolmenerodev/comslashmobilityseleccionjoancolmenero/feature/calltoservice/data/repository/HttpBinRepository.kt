package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.repository

import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.domain.model.HttpBinIp

interface HttpBinRepository {

    suspend fun getHttpBinIp(): HttpBinIp
}