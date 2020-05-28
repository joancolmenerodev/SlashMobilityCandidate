package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.list.presentation.di

import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.list.presentation.ListContract
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.list.presentation.ListPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class ListModuleDependenciesModule {

    @Binds
    abstract fun bindListPresenter(presenter: ListPresenter): ListContract.Presenter

}