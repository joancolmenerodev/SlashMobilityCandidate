package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.domain

import javax.inject.Inject

class GetHttpBinIpReversedUseCase @Inject constructor() {

    fun execute(stringToBeReversed: String) = stringToBeReversed.reversed()
}