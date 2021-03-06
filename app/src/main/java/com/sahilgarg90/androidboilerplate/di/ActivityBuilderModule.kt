package com.sahilgarg90.androidboilerplate.di

import com.sahilgarg90.androidboilerplate.ui.main.MainActivity
import com.sahilgarg90.androidboilerplate.di.subModules.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Sahil Garg on 06-03-2021.
 */

@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun provideMainActivity(): MainActivity
}