package com.sahilgarg90.androidboilerplate.utils.permissions

import android.os.Build
import androidx.annotation.NonNull
import com.sahilgarg90.androidboilerplate.base.BaseActivity

/**
 * Created by Sahil Garg on 06-03-2021.
 */

class PermissionManager {

    companion object {
        fun performTaskWithPermission(
            @NonNull activity: BaseActivity,
            @NonNull task: PermissionTask,
            permission: Permission,
            showInitialPopup: Boolean,
            showDeniedPopup: Boolean,
            setInitialPopupDismissible: Boolean = false,
            setDeniedPopupDismissible: Boolean = false,
            permissionDeniedCallback: PermissionDeniedCallback? = null
        ) {
            if (activity.hasPermission(permission))
                task.doTask()
            else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (activity.canRequestPermission(permission)) {
                        if (showInitialPopup) {
                            val permissionDialog = PermissionDialog(
                                activity,
                                task,
                                permission,
                                PermissionDialog.Mode.INIT,
                                permissionDeniedCallback
                            )
                            permissionDialog.setCanceledOnTouchOutside(setInitialPopupDismissible)
                            permissionDialog.show()
                        } else {
                            activity.requestPermission(permission, object : PermissionCallback {
                                override fun onGrant() {
                                    task.doTask()
                                }

                                override fun onDeny() {
                                    if (showDeniedPopup) {
                                        val permissionDialog = PermissionDialog(
                                            activity,
                                            task,
                                            permission,
                                            PermissionDialog.Mode.DENIED,
                                            permissionDeniedCallback
                                        )
                                        permissionDialog.setCanceledOnTouchOutside(
                                            setDeniedPopupDismissible
                                        )
                                        permissionDialog.setCancelable(setDeniedPopupDismissible)
                                        permissionDialog.show()
                                    } else {
                                        permissionDeniedCallback?.onDeny()
                                    }
                                }
                            })
                        }
                    } else {
                        if (showDeniedPopup) {
                            val permissionDialog = PermissionDialog(
                                activity,
                                task,
                                permission,
                                PermissionDialog.Mode.DENIED,
                                permissionDeniedCallback
                            )
                            permissionDialog.setCanceledOnTouchOutside(setDeniedPopupDismissible)
                            permissionDialog.setCancelable(setDeniedPopupDismissible)
                            permissionDialog.show()
                        } else {
                            permissionDeniedCallback?.onDeny()
                        }
                    }
                }
            }
        }
    }
}
