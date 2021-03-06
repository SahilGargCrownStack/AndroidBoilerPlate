package com.sahilgarg90.androidboilerplate.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Sahil Garg on 06-03-2021.
 */

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }
}