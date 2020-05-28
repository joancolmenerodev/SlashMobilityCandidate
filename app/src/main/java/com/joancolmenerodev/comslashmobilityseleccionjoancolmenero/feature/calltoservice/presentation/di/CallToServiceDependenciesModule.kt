package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.presentation.di

import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.repository.HttpBinRepository
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.repository.HttpBinRepositoryImpl
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.presentation.CallToServiceContract
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.presentation.CallToServicePresenter
import dagger.Binds
import dagger.Module

@Module
abstract class CallToServiceDependenciesModule {

    @Binds
    abstract fun bindCallToServicePresenter(presenter: CallToServicePresenter): CallToServiceContract.Presenter

    @Binds
    abstract fun bindHttBinRepository(repository: HttpBinRepositoryImpl): HttpBinRepository
}