package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.mapper

import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.model.HttpBinResponse
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.domain.model.HttpBinIp

fun HttpBinResponse.map() = HttpBinIp(ip = this.origin)