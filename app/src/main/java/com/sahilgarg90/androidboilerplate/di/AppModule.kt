package com.sahilgarg90.androidboilerplate.di

import android.app.Application
import android.content.Context
import com.sahilgarg90.androidboilerplate.di.network.AuthModule
import com.sahilgarg90.androidboilerplate.di.network.MainModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Sahil Garg on 06-03-2021.
 *
 * This class is main dagger module and it typically holds the reference of the application level
 * context instance. It will also includes all the network api reference modules
 */

@Module(includes = [AuthModule::class, MainModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }
}