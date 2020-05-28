package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.application.di.modules

import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.base.presentation.CoroutineDispatcherProvider
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.base.presentation.DefaultCoroutineDispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
object CoroutineDispatcherProviderModule {

    @Provides
    @Reusable
    fun provideDefaultCoroutineContextProvider(): CoroutineDispatcherProvider =
        DefaultCoroutineDispatcherProvider()
}