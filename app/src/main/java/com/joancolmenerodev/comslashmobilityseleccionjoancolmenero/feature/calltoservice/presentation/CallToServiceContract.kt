package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.presentation

import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.base.presentation.BasePresenter
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.base.presentation.PresenterView

interface CallToServiceContract {

    interface View : PresenterView {
        fun showHttpBinIp(ip: String)
        fun showReversedHttpBinIp(ipReversed: String)
        fun showNoInternetAvailable()
        fun showProgressBar(visible: Boolean)
        fun showNotFoundError()

    }

    interface Presenter : BasePresenter<View> {
        fun loadResults()
    }
}