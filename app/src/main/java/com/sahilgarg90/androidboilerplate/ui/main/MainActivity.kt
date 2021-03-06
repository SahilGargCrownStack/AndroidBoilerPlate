package com.sahilgarg90.androidboilerplate.ui.main

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.sahilgarg90.androidboilerplate.R
import com.sahilgarg90.androidboilerplate.base.BaseActivity
import com.sahilgarg90.androidboilerplate.databinding.MainActivityBinding

/**
 * Created by Sahil Garg on 06-03-2021.
 */

class MainActivity : BaseActivity() {

    private lateinit var activityBinding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = DataBindingUtil.setContentView(this, R.layout.main_activity)
    }
}