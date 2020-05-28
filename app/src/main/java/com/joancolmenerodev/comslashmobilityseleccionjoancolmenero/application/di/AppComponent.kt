package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.application.di

import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.application.App
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.data.networking.di.NetworkingModule
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.application.di.modules.AppFeaturesModule
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.application.di.modules.CoroutineDispatcherProviderModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        NetworkingModule::class,
        AppFeaturesModule::class,
        CoroutineDispatcherProviderModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: App): AppComponent
    }
}