package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.list.presentation.di

import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.list.presentation.ListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ListModule {

    @ContributesAndroidInjector(modules = [ListModuleDependenciesModule::class])
    abstract fun bindListFragment(): ListFragment
}