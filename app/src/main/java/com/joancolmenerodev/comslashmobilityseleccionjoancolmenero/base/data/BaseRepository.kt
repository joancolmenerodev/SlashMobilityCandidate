package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.base.data

import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.networking.exceptions.ServerException
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.networking.exceptions.ServiceException
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.networking.exceptions.SomethingWentWrongException

abstract class BaseRepository {

    inline fun <T> execute(block: () -> T): T =
        try {
            block()
        } catch (error: ServiceException) {
            if (error is ServerException.ServiceUnavailable) {
                throw SomethingWentWrongException(
                    error
                )
            } else {
                throw error
            }
        }
}