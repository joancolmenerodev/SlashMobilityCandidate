package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.list.domain

import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.base.domain.BaseUseCase
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.base.domain.Either
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.list.domain.exceptions.ListExceptions
import javax.inject.Inject

class GetRandomNumbersUseCase @Inject constructor() : BaseUseCase() {

    fun execute(numbers: Int): Either<ListExceptions, List<Int>> {
        return toEither {
            if (numbers == ZERO) throw ListExceptions.NumberNotValidException
            val list = defaultList.take(numbers)
            defaultList.shuffle()
            list
        }

    }

    companion object {
        private const val MIN_VALUE = 1
        private const val MAX_VALUE = 999
        private const val ZERO = 0
        private val defaultList = (MIN_VALUE..MAX_VALUE).shuffled() as MutableList<Int>
    }
}