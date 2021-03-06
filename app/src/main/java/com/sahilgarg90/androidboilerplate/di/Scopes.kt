package com.sahilgarg90.androidboilerplate.di

import javax.inject.Scope

/**
 * Created by Sahil Garg on 06-03-2021.
 */

@MustBeDocumented
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope

@MustBeDocumented
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FragmentScope

@MustBeDocumented
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class AdapterScope