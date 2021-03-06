package com.sahilgarg90.androidboilerplate.ui.main

import android.os.Bundle
import com.sahilgarg90.androidboilerplate.base.BaseActivity
import com.sahilgarg90.androidboilerplate.R

/**
 * Created by Sahil Garg on 06-03-2021.
 */

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}