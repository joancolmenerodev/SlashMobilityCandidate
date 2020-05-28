package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.domain

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class GetHttpBinIpReversedUseCaseTest {

    private lateinit var useCase: GetHttpBinIpReversedUseCase

    @Before
    fun setUp() {
        useCase = GetHttpBinIpReversedUseCase()
    }

    @Test
    fun `given we want to reverse a string then it reverses it`() {
        //ASSIGN
        val stringToBeReversed = "slashmobility"
        val expectedResult = "ytilibomhsals"

        //ACT
        val result = useCase.execute(stringToBeReversed)

        //ASSERT
        assertEquals(expectedResult, result)
    }

    @Test
    fun `given we want to reverse an empty string then it returns an empty string`() {
        //ASSIGN
        val stringToBeReversed = ""
        val expectedResult = ""

        //ACT
        val result = useCase.execute(stringToBeReversed)

        //ASSERT
        assertEquals(expectedResult, result)
    }
}