package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.domain.exceptions

sealed class CallToServiceExceptions : Exception() {
    object IpNotFound : CallToServiceExceptions()
    object InformationNotAvailable : CallToServiceExceptions()
}