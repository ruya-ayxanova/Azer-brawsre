package com.azer.browser

import android.content.Context

object BrowserPrivacyFactory {

    fun createManager(context: Context): BrowserPrivacyManager {
        return BrowserPrivacyManager(context)
    }

    fun createController(context: Context): BrowserPrivacyController {
        return BrowserPrivacyController(context)
    }

    fun createRepository(context: Context): BrowserPrivacyRepository {
        return BrowserPrivacyRepository(
            BrowserPrivacyStorage(context)
        )
    }

    fun createPermissionRepository(
        context: Context
    ): BrowserSitePermissionRepository {
        return BrowserSitePermissionRepository(
            BrowserSitePermissionStorage(context)
        )
    }

    fun createCleaner(): BrowserPrivacyCleaner {
        return BrowserPrivacyCleaner()
    }
}
