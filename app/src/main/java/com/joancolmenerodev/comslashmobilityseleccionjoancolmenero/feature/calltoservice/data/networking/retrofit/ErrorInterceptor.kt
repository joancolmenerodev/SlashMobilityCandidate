package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.networking.retrofit

import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.networking.exceptions.ClientException
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.networking.exceptions.NoInternetConnection
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.networking.exceptions.ServerException
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.networking.exceptions.ServiceException
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.net.HttpURLConnection
import javax.inject.Inject

class ErrorInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val response =
            try {
                chain.proceed(chain.request())
            } catch (error: IOException) {
                throw NoInternetConnection(error.cause)
            }
        if (!response.isSuccessful) {
            when (response.code) {
                HttpURLConnection.HTTP_UNAVAILABLE -> throw ServerException.ServiceUnavailable
                HttpURLConnection.HTTP_NOT_FOUND -> throw ClientException.NotFound
                HttpURLConnection.HTTP_CLIENT_TIMEOUT -> throw ClientException.RequestTimeout
                else -> throw ServiceException(
                    IllegalStateException("The status code ${response.code} was received but not handled!")
                )
            }
        }
        return response
    }
}