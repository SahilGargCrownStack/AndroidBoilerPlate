package com.sahilgarg90.androidboilerplate.utils.permissions

import android.app.Application
import com.sahilgarg90.androidboilerplate.base.BasePreferences
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Sahil Garg on 06-03-2021.
 */

@Singleton
class PermissionPreferences @Inject constructor(application: Application) :
    BasePreferences(PREF_NAME, application) {

    companion object {
        private const val PREF_NAME = "PermissionPrefs"
    }

    fun setPermissionRequestedStatus(permissionName: String) {
        putPreference(permissionName, true)
    }

    fun isPermissionRequestedBefore(permissionName: String): Boolean {
        return getPreference(permissionName, false)
    }
}