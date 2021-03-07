package com.sahilgarg90.androidboilerplate.utils.permissions;

/**
 * Created by Sahil Garg on 06-03-2021.
 *
 * This interface will return callback methods after user interact with the runtime permission default dialog.
 */

public interface PermissionCallback {
    void onGrant();

    void onDeny();
}

