package com.azer.browser

data class BrowserSitePermission(
    val host: String,
    val permission: BrowserPermissionType,
    val allowed: Boolean,
    val updatedAt: Long = System.currentTimeMillis()
)
