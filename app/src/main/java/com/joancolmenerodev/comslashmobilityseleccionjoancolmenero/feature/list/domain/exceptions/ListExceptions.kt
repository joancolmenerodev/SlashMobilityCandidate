package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.list.domain.exceptions

import java.lang.Exception

sealed class ListExceptions : Exception() {
    object NumberNotValidException: ListExceptions()
    object EmptyList: ListExceptions()
}