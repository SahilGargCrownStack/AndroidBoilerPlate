package com.sahilgarg90.androidboilerplate.utils.permissions

import android.Manifest
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.sahilgarg90.androidboilerplate.R

/**
 * Created by Sahil Garg on 06-03-2021.
 *
 * This class holds information related to a particular type of permission which user has to approve at runtime.
 */

class Permission private constructor(
    val permissionName: String,
    val requestCode: Int,
    @param:StringRes @field:StringRes val preDialogMessage: Int,
    @param:StringRes @field:StringRes val deniedDialogMessage: Int,
    @param:DrawableRes @field:DrawableRes val dialogImage: Int
) {
    companion object {

        private const val LOCATION = Manifest.permission.ACCESS_FINE_LOCATION
        private const val WRITE_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE
        private const val REQUEST_LOCATION = 10101
        private const val REQUEST_STORAGE = 10102

        fun getLocationPermissionData(): Permission {
            return Permission(
                LOCATION,
                REQUEST_LOCATION,
                R.string.location_permission_pre_dialog_message,
                R.string.location_permission_denied_dialog_message,
                R.drawable.ic_location
            )
        }

        fun getStoragePermissionData(): Permission {
            return Permission(
                WRITE_STORAGE,
                REQUEST_STORAGE,
                R.string.storage_permission_pre_dialog_message,
                R.string.storage_permission_denied_dialog_message,
                R.drawable.ic_folder
            )
        }
    }
}
