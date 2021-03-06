package com.sahilgarg90.androidboilerplate.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sahilgarg90.androidboilerplate.ui.main.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Sahil Garg on 06-03-2021.
 */

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(customViewModelFactory: CustomViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel
}