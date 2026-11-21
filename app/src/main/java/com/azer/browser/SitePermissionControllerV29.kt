package com.azer.browser

import android.content.Context

class SitePermissionControllerV29(context: Context) {

    private val repository = SitePermissionRepositoryV29(
        SitePermissionDataSource(
            SitePermissionLocalStorage(context)
        )
    )

    private val resolver = SitePermissionResolver(repository)

    fun all(): List<SitePermissionRecord> {
        return repository.getAll()
    }

    fun forHost(host: String): List<SitePermissionRecord> {
        return repository.getForHost(host)
    }

    fun get(
        host: String,
        type: BrowserPermissionType
    ): SitePermissionAction {
        return resolver.resolve(host, type)
    }

    fun set(
        host: String,
        type: BrowserPermissionType,
        action: SitePermissionAction
    ) {
        if (!SitePermissionHostUtils.isValidHost(host)) return

        repository.set(host, type, action)
    }

    fun removeSite(host: String) {
        repository.removeHost(host)
    }

    fun clearAll() {
        repository.clear()
    }

    fun summary(host: String): SitePermissionSummary {
        return SitePermissionSummaryBuilder.build(
            host,
            repository.getAll()
        )
    }
}
