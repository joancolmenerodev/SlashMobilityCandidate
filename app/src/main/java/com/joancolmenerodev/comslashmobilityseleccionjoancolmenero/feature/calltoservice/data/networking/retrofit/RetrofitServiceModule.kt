package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.networking.retrofit

import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.HttpBinService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit

@Module
object RetrofitServiceModule {

    @Provides
    @Reusable
    fun provideIpService(retrofit: Retrofit): HttpBinService {
        return retrofit.create(HttpBinService::class.java)
    }

}