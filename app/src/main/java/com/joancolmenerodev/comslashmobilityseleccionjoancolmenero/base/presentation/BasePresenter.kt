package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.base.presentation

interface BasePresenter<T> {
    fun onViewReady(view: T)
    fun onViewDestroyed()
}