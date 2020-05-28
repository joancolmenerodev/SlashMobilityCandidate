package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.networking.di

import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.BuildConfig
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.networking.retrofit.ErrorInterceptor
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.networking.retrofit.RetrofitServiceModule
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [RetrofitServiceModule::class])
object NetworkingModule {

    @Provides
    @Singleton
    fun provideRetrofit(httpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        errorInterceptor: ErrorInterceptor
    ): OkHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(httpLoggingInterceptor)
        .addInterceptor(errorInterceptor)
        .build()

    @Provides
    @Singleton
    fun provideHttpLogginInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = when {
            BuildConfig.DEBUG -> HttpLoggingInterceptor.Level.BODY
            else -> HttpLoggingInterceptor.Level.NONE
        }
        return loggingInterceptor
    }
}

private const val BASE_URL = "http://httpbin.org/"