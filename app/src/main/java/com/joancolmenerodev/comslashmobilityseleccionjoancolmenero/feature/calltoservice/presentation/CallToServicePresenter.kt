package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.presentation

import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.base.presentation.AbstractPresenter
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.base.presentation.CoroutineDispatcherProvider
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.domain.GetHttpBinIpReversedUseCase
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.domain.GetHttpBinIpUseCase
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.domain.exceptions.CallToServiceExceptions
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.domain.model.HttpBinIp
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CallToServicePresenter @Inject constructor(
    val getHttpBinIpUseCase: GetHttpBinIpUseCase,
    val getHttpBinIpReversedUseCase: GetHttpBinIpReversedUseCase,
    val dispatcher: CoroutineDispatcherProvider
) : AbstractPresenter<CallToServiceContract.View>(dispatcher), CallToServiceContract.Presenter {

    override fun loadResults() {
        view?.showProgressBar(true)
        launch {
            withContext(dispatcher.io()) {
                getHttpBinIpUseCase.execute()
            }.fold(
                ::handleFailure,
                ::handleSuccess
            )
            view?.showProgressBar(false)
        }
    }

    private fun handleFailure(failure: CallToServiceExceptions) {
        when (failure) {
            is CallToServiceExceptions.InformationNotAvailable -> {
                view?.showNoInternetAvailable()
            }
            is CallToServiceExceptions.IpNotFound -> {
                view?.showNotFoundError()
            }
        }
    }

    private fun handleSuccess(httpBinIp: HttpBinIp) {
        val ip = httpBinIp.ip
        if (ip.isBlank()) {
            view?.showNotFoundError()
        } else {
            view?.showHttpBinIp(ip)
            val reversedIp = reverseIp(ip)
            view?.showReversedHttpBinIp(reversedIp)
        }
    }

    private fun reverseIp(ip: String) =
        getHttpBinIpReversedUseCase.execute(ip)


}