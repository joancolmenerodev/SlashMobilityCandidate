package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.repository

import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.base.data.BaseRepository
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.HttpBinService
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.mapper.map
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.networking.exceptions.ClientException
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.domain.exceptions.CallToServiceExceptions
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.domain.model.HttpBinIp
import javax.inject.Inject

class HttpBinRepositoryImpl @Inject constructor(val service: HttpBinService) : BaseRepository(),
    HttpBinRepository {
    override suspend fun getHttpBinIp(): HttpBinIp {
        return execute {
            try {
                service.getHttpBin().map()
            } catch (exception: Exception) {
                when (exception) {
                    is ClientException.NotFound -> throw CallToServiceExceptions.IpNotFound
                    else -> throw CallToServiceExceptions.InformationNotAvailable
                }
            }
        }
    }
}