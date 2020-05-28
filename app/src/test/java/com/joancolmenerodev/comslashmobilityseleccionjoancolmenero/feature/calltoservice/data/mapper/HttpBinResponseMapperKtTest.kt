package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.mapper

import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.model.ArgsDTO
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.model.HeadersDTO
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.model.HttpBinResponse
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.domain.model.HttpBinIp
import org.junit.Assert.assertEquals
import org.junit.Test

class HttpBinResponseMapperKtTest {


    @Test
    fun `HttpBinResponse to HttBinIp mapper`() {
        //ASSIGN
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

        val expectedResult = HttpBinIp(
            ip = "62.174.186.90"
        )

        //ACT
        val result = response.map()

        //ASSERT
        assertEquals(result, expectedResult)
    }
}