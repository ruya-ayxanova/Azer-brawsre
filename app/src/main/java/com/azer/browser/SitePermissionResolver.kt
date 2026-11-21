package com.azer.browser

class SitePermissionResolver(
    private val repository: SitePermissionRepositoryV29
) {

    fun resolve(
        host: String,
        type: BrowserPermissionType
    ): SitePermissionAction {
        return repository.get(host, type)?.action
            ?: SitePermissionDefaults.actionFor(type)
    }

    fun isAllowed(
        host: String,
        type: BrowserPermissionType
    ): Boolean {
        return resolve(host, type) == SitePermissionAction.ALLOW
    }

    fun isBlocked(
        host: String,
        type: BrowserPermissionType
    ): Boolean {
        return resolve(host, type) == SitePermissionAction.BLOCK
    }
}
