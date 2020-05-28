package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.repository

import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.HttpBinService
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.model.ArgsDTO
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.model.HeadersDTO
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.model.HttpBinResponse
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.networking.exceptions.ClientException
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.domain.exceptions.CallToServiceExceptions
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.domain.model.HttpBinIp
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.io.IOException

class HttpBinRepositoryImplTest {

    private lateinit var httpBinRepository: HttpBinRepository
    private val mockService: HttpBinService = mockk()

    @Before
    fun setUp() {
        httpBinRepository =
            HttpBinRepositoryImpl(mockService)
    }

    @Test
    fun `given user press the button to load data, then it returns the origin`() {
        //ASSIGN
        coEvery { mockService.getHttpBin() } answers { response }

        //ACT
        val result =
            runBlocking { httpBinRepository.getHttpBinIp() }

        //ASSERT
        assertEquals(expectedResult, result)

    }

    @Test(expected = CallToServiceExceptions.IpNotFound::class)
    fun `given user press the button to load data and it returns a not found it returns a notFoundException`() {

        //ASSIGN
        val returnedException = ClientException.NotFound
        coEvery { mockService.getHttpBin() } throws returnedException

        //ACT
        runBlocking { httpBinRepository.getHttpBinIp() }

    }

    @Test(expected = CallToServiceExceptions.InformationNotAvailable::class)
    fun `given user press the button to load data but there's no internet connection it return InformationNotAvailableException`() {

        //ASSIGN
        coEvery { mockService.getHttpBin() } throws ClientException.RequestTimeout

        //ACT
        runBlocking { httpBinRepository.getHttpBinIp() }

    }

    companion object {
        val response = HttpBinResponse(
            args = ArgsDTO("id1"),
            headers = HeadersDTO(
                accept = "*/*",
                host = "httpbin.org",
                userAgent = "insomnia/7.1.1",
                xAmznTraceId = "Root=1-5ece36a2-209db95ff1ffd0388ec",
                xCmcProApiKey = "badb6455-0340-4bfb-9f60-808bc0d"
            ),
            origin = "62.174.186.90",
            url = "http://httpbin.org/get?id=5334"
        )

        val expectedResult = HttpBinIp(ip = "62.174.186.90")
    }
}