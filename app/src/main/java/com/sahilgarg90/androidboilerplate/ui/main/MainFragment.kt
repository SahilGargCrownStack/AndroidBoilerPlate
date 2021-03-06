package com.sahilgarg90.androidboilerplate.ui.main

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.sahilgarg90.androidboilerplate.base.BaseActivity
import com.sahilgarg90.androidboilerplate.base.BaseFragment
import com.sahilgarg90.androidboilerplate.R
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
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        PermissionManager.performTaskWithPermission(
            requireActivity() as BaseActivity,
            object : PermissionTask {
                @SuppressLint("MissingPermission")
                override fun doTask() {
                    val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
                    intent.type = "*/*"
                    intent.putExtra(Intent.EXTRA_MIME_TYPES, arrayOf("image/*", "video/*"))
                    intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
                    intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true)
                    startActivity(Intent.createChooser(intent, "Select Image or Video"))
                }
            },
            Permission.getStoragePermissionData(),
            showInitialPopup = true,
            showDeniedPopup = true
        )
    }

}