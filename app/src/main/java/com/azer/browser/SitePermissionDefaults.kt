package com.azer.browser

object SitePermissionDefaults {

    fun actionFor(
        type: BrowserPermissionType
    ): SitePermissionAction {
        return when (type) {
            BrowserPermissionType.CAMERA,
            BrowserPermissionType.MICROPHONE,
            BrowserPermissionType.LOCATION,
            BrowserPermissionType.NOTIFICATIONS,
            BrowserPermissionType.CLIPBOARD,
            BrowserPermissionType.STORAGE -> SitePermissionAction.ASK
        }
    }
}
