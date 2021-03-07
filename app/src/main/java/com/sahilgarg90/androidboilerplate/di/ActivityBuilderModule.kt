package com.sahilgarg90.androidboilerplate.di

import com.sahilgarg90.androidboilerplate.ui.main.MainActivity
import com.sahilgarg90.androidboilerplate.di.subModules.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Sahil Garg on 06-03-2021.
 *
 * This class is dagger module and is used to get Reference of the all the activities in the project.
 */

@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun provideMainActivity(): MainActivity
}