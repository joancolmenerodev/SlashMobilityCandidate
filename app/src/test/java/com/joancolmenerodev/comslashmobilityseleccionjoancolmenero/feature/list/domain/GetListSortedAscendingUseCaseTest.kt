package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.list.domain

import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.base.domain.Either
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.list.domain.exceptions.ListExceptions
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class GetListSortedAscendingUseCaseTest {

    private lateinit var useCase: GetListSortedAscendingUseCase

    @Before
    fun setUp() {
        useCase = GetListSortedAscendingUseCase()
    }

    @Test
    fun `given we pass a list of Integers as a parameters the result is a different list with the items sorted`() {
        //ASSIGN

        //ACT
        val result = useCase.execute(listUnSorted)

        //ASSERT
        assertEquals(result, listSorted)

    }

    @Test
    fun `given we pass an empty list of Integers as a parameters the result is an EmptyListException`() {
        //ASSIGN

        //ACT
        val result = useCase.execute(emptyList)

        //ASSERT
        assertEquals(result, Either.Left(ListExceptions.EmptyList))

    }

    companion object {
        private val listUnSorted = arrayListOf(5, 4, 3, 2, 1)
        private val listSorted = Either.Right(arrayListOf(1, 2, 3, 4, 5))
        private val emptyList = emptyList<Int>()
    }


}