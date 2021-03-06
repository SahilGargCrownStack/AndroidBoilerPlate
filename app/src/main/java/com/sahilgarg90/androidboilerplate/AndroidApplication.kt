package com.sahilgarg90.androidboilerplate

import com.sahilgarg90.androidboilerplate.di.AppComponent
import com.sahilgarg90.androidboilerplate.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Created by Sahil Garg on 06-03-2021.
 */

class AndroidApplication : DaggerApplication() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent.inject(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent = DaggerAppComponent.builder().application(this).build()
        return appComponent
    }

}