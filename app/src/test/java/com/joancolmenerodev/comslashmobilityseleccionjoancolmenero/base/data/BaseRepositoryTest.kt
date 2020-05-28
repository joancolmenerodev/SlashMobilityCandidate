package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.base.data

import android.accounts.NetworkErrorException
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.networking.exceptions.ServerException
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.networking.exceptions.SomethingWentWrongException
import io.mockk.mockk
import org.junit.Assert
import org.junit.Test

class BaseRepositoryTest {

    private var baseRepository: BaseRepository = mockk()

    @Test
    fun `given we want to execute a String then we receive the same String as a result`() {

        //Assign
        val word = "Whatever"

        //Act
        val result = baseRepository.execute { word }

        //Assert
        Assert.assertEquals(word, result)
    }

    @Test(expected = SomethingWentWrongException::class)
    fun `given the block of execute throws a ServiceUnavailable then the execute returns SomethingWentWrongException`() {

        //Act
        baseRepository.execute { throw ServerException.ServiceUnavailable }

    }

    @Test(expected = NetworkErrorException::class)
    fun `given the block of execute throws a NetworkErrorException then the execute returns the same exception`() {

        //Act
        baseRepository.execute { throw NetworkErrorException() }

    }

}