package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.domain

import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.base.domain.BaseUseCase
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.base.domain.Either
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.repository.HttpBinRepository
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.domain.exceptions.CallToServiceExceptions
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.domain.model.HttpBinIp
import javax.inject.Inject

class GetHttpBinIpUseCase @Inject constructor(val repository: HttpBinRepository) : BaseUseCase() {

    suspend fun execute(): Either<CallToServiceExceptions, HttpBinIp> =
        toEither {
            repository.getHttpBinIp()
        }

}