package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.list.domain

import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.list.domain.exceptions.ListExceptions
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Test


class GetRandomNumbersUseCaseTest {
    private lateinit var useCase: GetRandomNumbersUseCase

    @Before
    fun setUp() {
        useCase = GetRandomNumbersUseCase()
    }

    @Test
    fun `given we pass a number of desired random numbers it returns a list with the same size`() {
        //ASSIGN

        //ACT
        val result = useCase.execute(DESIRED_RANDOM_NUMBERS)

        //ASSERT
        result.fold(
            { fail("should be right") },
            { assertEquals(it.size, DESIRED_RANDOM_NUMBERS) }
        )

    }

    @Test
    fun `given we pass 0 as a number of desired random numbers it returns a EmptyListException`() {
        //ASSIGN
        val exception = ListExceptions.NumberNotValidException

        //ACT
        val result = useCase.execute(ZERO)

        //ASSERT
        result.fold(
            { assertEquals(exception, it) },
            { fail("should be left") }
        )

    }

    companion object {
        private const val DESIRED_RANDOM_NUMBERS = 4
        private const val ZERO = 0
    }
}