package com.azer.browser

data class SitePermissionSummary(
    val host: String,
    val allowedCount: Int,
    val blockedCount: Int,
    val askCount: Int
) {
    val total: Int
        get() = allowedCount + blockedCount + askCount
}
