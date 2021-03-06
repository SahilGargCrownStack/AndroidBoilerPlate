package com.sahilgarg90.androidboilerplate.di.subModules

import com.sahilgarg90.androidboilerplate.di.FragmentScope
import com.sahilgarg90.androidboilerplate.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Sahil Garg on 06-03-2021.
 */

@Module
abstract class MainActivityModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindMainFragment(): MainFragment
}