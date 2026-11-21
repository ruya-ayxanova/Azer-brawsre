package com.azer.browser

object SitePermissionFormatter {

    fun permissionName(type: BrowserPermissionType): String {
        return when (type) {
            BrowserPermissionType.CAMERA -> "Kamera"
            BrowserPermissionType.MICROPHONE -> "Mikrofon"
            BrowserPermissionType.LOCATION -> "Konum"
            BrowserPermissionType.NOTIFICATIONS -> "Bildirimler"
            BrowserPermissionType.STORAGE -> "Depolama"
            BrowserPermissionType.CLIPBOARD -> "Pano"
        }
    }

    fun actionName(action: SitePermissionAction): String {
        return when (action) {
            SitePermissionAction.ALLOW -> "İzin verildi"
            SitePermissionAction.BLOCK -> "Engellendi"
            SitePermissionAction.ASK -> "Her zaman sor"
        }
    }
}
