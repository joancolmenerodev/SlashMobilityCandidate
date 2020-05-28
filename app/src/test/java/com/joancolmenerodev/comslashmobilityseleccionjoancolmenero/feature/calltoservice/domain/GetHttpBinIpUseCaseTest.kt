package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.domain

import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.base.domain.Either
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.repository.HttpBinRepository
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.domain.exceptions.CallToServiceExceptions
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.domain.model.HttpBinIp
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetHttpBinIpUseCaseTest {

    private lateinit var useCase: GetHttpBinIpUseCase
    private val mockRepository: HttpBinRepository = mockk()

    @Before
    fun setUp() {
        useCase = GetHttpBinIpUseCase(mockRepository)
    }

    @Test
    fun `given we ask for a HttpBin it returns an either right with the correct Ip`() {
        //ASSIGN
        coEvery { mockRepository.getHttpBinIp() } answers { expectedResult }

        //ACT
        val result = runBlocking { useCase.execute() }

        //ASSERT
        assertEquals(result, Either.Right(expectedResult))

    }

    @Test
    fun `given we ask for a HttpBin it returns an either left when the Ip is not found`() {
        val ipNotFound = CallToServiceExceptions.IpNotFound
        coEvery { mockRepository.getHttpBinIp() } throws ipNotFound

        //ACT
        val result = runBlocking { useCase.execute() }

        //ASSERT
        assertEquals(result, Either.Left(ipNotFound))

    }

    @Test
    fun `given we ask for a HttpBin it returns an either left when theres a network error`() {
        val informationNotAvailable = CallToServiceExceptions.InformationNotAvailable
        coEvery { mockRepository.getHttpBinIp() } throws informationNotAvailable

        //ACT
        val result = runBlocking { useCase.execute() }

        //ASSERT
        assertEquals(result, Either.Left(informationNotAvailable))

    }


    companion object {
        val expectedResult = HttpBinIp(ip = "62.174.186.90")
    }
}