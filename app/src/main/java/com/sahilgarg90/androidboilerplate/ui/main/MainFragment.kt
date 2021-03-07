package com.sahilgarg90.androidboilerplate.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sahilgarg90.androidboilerplate.base.BaseActivity
import com.sahilgarg90.androidboilerplate.base.BaseFragment
import com.sahilgarg90.androidboilerplate.databinding.MainFragmentBinding
import com.sahilgarg90.androidboilerplate.ui.main.viewmodel.MainViewModel
import com.sahilgarg90.androidboilerplate.utils.permissions.Permission
import com.sahilgarg90.androidboilerplate.utils.permissions.PermissionManager
import com.sahilgarg90.androidboilerplate.utils.permissions.PermissionTask
import javax.inject.Inject

/**
 * Created by Sahil Garg on 06-03-2021.
 */

class MainFragment : BaseFragment() {

    companion object {
        private const val TAG = "MainFragment"

        fun getInstance() = MainFragment()
    }

    private lateinit var fragmentBinding: MainFragmentBinding

    private lateinit var viewModel: MainViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentBinding = MainFragmentBinding.inflate(inflater, container, false)
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.someData.observe(viewLifecycleOwner, Observer { data ->
            // Receives the data information whenever it got changed
            Log.d(TAG, data)
        })

        // Call the view model method to get some information
        viewModel.getSomeData()
    }

    /**
     * Method demonstrating how to call out for runtime permissions
     */
    private fun getStoragePermission() {
        PermissionManager.performTaskWithPermission(
            requireActivity() as BaseActivity,
            object : PermissionTask {
                override fun doTask() {
                    // Implement the code after having storage permission
                }
            },
            Permission.getStoragePermissionData(),
            showInitialPopup = true,
            showDeniedPopup = true
        )
    }

}