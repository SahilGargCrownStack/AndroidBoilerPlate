package com.sahilgarg90.androidboilerplate.utils.permissions;

/**
 * Created by Sahil Garg on 06-03-2021.
 */

public interface PermissionCallback {
    void onGrant();

    void onDeny();
}
