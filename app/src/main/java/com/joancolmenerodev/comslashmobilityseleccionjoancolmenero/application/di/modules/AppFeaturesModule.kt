package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.application.di.modules

import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.presentation.di.CallToServiceModule
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.list.presentation.di.ListModule
import dagger.Module

@Module(includes = [CallToServiceModule::class, ListModule::class])
object AppFeaturesModule