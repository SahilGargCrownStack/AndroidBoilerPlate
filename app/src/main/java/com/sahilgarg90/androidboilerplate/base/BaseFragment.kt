package com.sahilgarg90.androidboilerplate.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection

/**
 * Created by Sahil Garg on 06-03-2021.
 *
 * This is the Base class to extend for each fragment in the project.
 * Currently it has code of dagger fragment injection.
 */

open class BaseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }
}