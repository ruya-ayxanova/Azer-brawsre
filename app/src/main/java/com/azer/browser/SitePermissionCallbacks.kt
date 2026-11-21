package com.azer.browser

interface SitePermissionCallbacks {

    fun onPermissionChanged(
        host: String,
        type: BrowserPermissionType,
        action: SitePermissionAction
    )

    fun onHostRemoved(host: String)

    fun onAllPermissionsCleared()
}
