package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.presentation.di

import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.presentation.CallToServiceFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class CallToServiceModule {

    @ContributesAndroidInjector(modules = [CallToServiceDependenciesModule::class])
    abstract fun bindCallToServiceFragment(): CallToServiceFragment
}