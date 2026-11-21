package com.azer.browser

object SitePermissionKey {

    fun create(
        host: String,
        type: BrowserPermissionType
    ): String {
        return "${host.lowercase()}_${type.name}"
    }
}
