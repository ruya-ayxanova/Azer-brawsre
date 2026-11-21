package com.azer.browser

data class SitePermissionRecord(
    val host: String,
    val type: BrowserPermissionType,
    val action: SitePermissionAction,
    val updatedAt: Long = System.currentTimeMillis()
)
