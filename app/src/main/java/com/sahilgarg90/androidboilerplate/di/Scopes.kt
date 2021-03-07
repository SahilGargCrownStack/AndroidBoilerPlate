package com.sahilgarg90.androidboilerplate.di

import javax.inject.Scope

/**
 * Created by Sahil Garg on 06-03-2021.
 *
 * This class is holds the custom annotation made to be used in the project for dependency injection.
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