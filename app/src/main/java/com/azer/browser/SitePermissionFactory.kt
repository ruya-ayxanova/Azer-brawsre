package com.azer.browser

import android.content.Context

object SitePermissionFactory {

    fun createController(
        context: Context
    ): SitePermissionControllerV29 {
        return SitePermissionControllerV29(context)
    }

    fun createRepository(
        context: Context
    ): SitePermissionRepositoryV29 {
        return SitePermissionRepositoryV29(
            SitePermissionDataSource(
                SitePermissionLocalStorage(context)
            )
        )
    }

    fun createListView(
        context: Context,
        onClick: (SitePermissionRecord) -> Unit
    ): SitePermissionListView {
        return SitePermissionListView(
            context,
            onClick
        )
    }
}
