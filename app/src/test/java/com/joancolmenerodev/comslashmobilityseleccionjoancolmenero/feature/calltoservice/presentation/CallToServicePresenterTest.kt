package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.presentation

import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.base.domain.Either
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.base.presentation.TestCoroutineDispatcherProvider
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.domain.GetHttpBinIpReversedUseCase
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.domain.GetHttpBinIpUseCase
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.domain.exceptions.CallToServiceExceptions
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.domain.model.HttpBinIp
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.unmockkAll
import org.junit.After
import org.junit.Before
import org.junit.Test

class CallToServicePresenterTest {

    private lateinit var presenter: CallToServiceContract.Presenter

    @RelaxedMockK
    private lateinit var mockView: CallToServiceContract.View

    @MockK
    private lateinit var mockUseCase: GetHttpBinIpUseCase

    @MockK
    private lateinit var mockUseCaseReverse: GetHttpBinIpReversedUseCase

    private val testCoroutineDispatcher = TestCoroutineDispatcherProvider()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        presenter = CallToServicePresenter(mockUseCase, mockUseCaseReverse, testCoroutineDispatcher)
        presenter.onViewReady(mockView)
    }

    @After
    fun tearDown() {
        presenter.onViewDestroyed()
        unmockkAll()
    }

    @Test
    fun `given user press on call to service button then it displays the data`() {

        //ASSIGN
        coEvery { mockUseCase.execute() } answers { Either.Right(NORMAL_STRING) }
        coEvery { mockUseCaseReverse.execute(any()) } answers { REVERSED_STRING }

        //ACT
        presenter.loadResults()

        //ASSERT
        coVerify(exactly = 1) {
            mockView.showProgressBar(true)
            mockView.showHttpBinIp(NORMAL_STRING.ip)
            mockView.showReversedHttpBinIp(REVERSED_STRING)
            mockView.showProgressBar(false)
        }

    }

    @Test
    fun `given user press on call to service button then it returns InformationNOtAvailable then it shows no internet available`() {

        //ASSIGN
        coEvery { mockUseCase.execute() } answers { Either.Left(CallToServiceExceptions.InformationNotAvailable) }

        //ACT
        presenter.loadResults()

        //ASSERT
        coVerify(exactly = 1) {
            mockView.showProgressBar(true)
            mockView.showNoInternetAvailable()
            mockView.showProgressBar(false)
        }

    }

    @Test
    fun `given user press on call to service button then it returns IpNotFound then it shows no not found layout`() {

        //ASSIGN
        coEvery { mockUseCase.execute() } answers { Either.Left(CallToServiceExceptions.IpNotFound) }

        //ACT
        presenter.loadResults()

        //ASSERT
        coVerify(exactly = 1) {
            mockView.showProgressBar(true)
            mockView.showNotFoundError()
            mockView.showProgressBar(false)
        }

    }

    @Test
    fun `given user press on call to service button then it returns an empty Ip it shows notFoundError`() {

        //ASSIGN
        coEvery { mockUseCase.execute() } answers { Either.Right(EMPTY_HTTP_BIN_IP) }

        //ACT
        presenter.loadResults()

        //ASSERT
        coVerify(exactly = 1) {
            mockView.showProgressBar(true)
            mockView.showNotFoundError()
            mockView.showProgressBar(false)
        }

    }

    companion object {
        private const val REVERSED_STRING = "09.681.471.26"
        private val NORMAL_STRING = HttpBinIp(ip = "62.174.186.90")
        private val EMPTY_HTTP_BIN_IP = HttpBinIp(ip = "")

    }
}