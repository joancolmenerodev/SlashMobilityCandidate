package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.list.domain

import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.base.domain.BaseUseCase
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.base.domain.Either
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.list.domain.exceptions.ListExceptions
import javax.inject.Inject

class GetListSortedAscendingUseCase @Inject constructor() : BaseUseCase() {

    fun execute(list: List<Int>): Either<ListExceptions, ArrayList<Int>> = toEither {
        if (list.isEmpty()) throw ListExceptions.EmptyList
        val newList = arrayListOf<Int>()
        newList.addAll(list)
        newList.sort()
        newList
    }
}