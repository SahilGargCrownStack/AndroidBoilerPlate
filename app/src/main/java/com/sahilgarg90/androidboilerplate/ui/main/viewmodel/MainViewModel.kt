package com.sahilgarg90.androidboilerplate.ui.main.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import javax.inject.Inject

/**
 * Created by Sahil Garg on 06-03-2021.
 */

class MainViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var context: Context
}