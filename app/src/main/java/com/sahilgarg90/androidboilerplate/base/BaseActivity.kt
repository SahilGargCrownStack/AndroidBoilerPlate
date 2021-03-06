package com.sahilgarg90.androidboilerplate.base

import android.annotation.TargetApi
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.SparseArray
import androidx.annotation.NonNull
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.sahilgarg90.androidboilerplate.utils.permissions.Permission
import com.sahilgarg90.androidboilerplate.utils.permissions.PermissionCallback
import com.sahilgarg90.androidboilerplate.utils.permissions.PermissionPreferences
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 * Created by Sahil Garg on 06-03-2021.
 */

open class BaseActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var permissionPreferences: PermissionPreferences

    private val permissionCallbackSparseArray = SparseArray<PermissionCallback>()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }

    fun hasPermission(permission: Permission): Boolean {
        return if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            true
        } else {
            checkSelfPermission(permission.permissionName) == PackageManager.PERMISSION_GRANTED
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun canRequestPermission(permission: Permission): Boolean {
        return !permissionPreferences.isPermissionRequestedBefore(permission.permissionName)
                || shouldShowRequestPermissionRationale(permission.permissionName)
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    fun requestPermission(permission: Permission, permissionCallback: PermissionCallback) {
        permissionCallbackSparseArray.put(permission.requestCode, permissionCallback)
        permissionPreferences.setPermissionRequestedStatus(permission.permissionName)
        requestPermissions(arrayOf(permission.permissionName), permission.requestCode)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        @NonNull permissions: Array<String>,
        @NonNull grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        val callback = permissionCallbackSparseArray.get(requestCode, null) ?: return
        if (grantResults.isNotEmpty()) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                callback.onGrant()
            } else {
                callback.onDeny()
            }
        } else {
            callback.onDeny()
        }
    }
}