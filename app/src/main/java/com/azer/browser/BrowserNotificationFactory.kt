package com.azer.browser

import android.content.Context

object BrowserNotificationFactory {

    fun createController(
        context: Context
    ): BrowserNotificationController {
        return BrowserNotificationController(context)
    }

    fun createRepository(
        context: Context
    ): BrowserNotificationRepository {
        return BrowserNotificationRepository(context)
    }

    fun createSettingsManager(
        context: Context
    ): BrowserNotificationSettingsManager {
        return BrowserNotificationSettingsManager(context)
    }

    fun createListView(
        context: Context,
        onOpen: (BrowserNotification) -> Unit,
        onDelete: (BrowserNotification) -> Unit
    ): BrowserNotificationListView {
        return BrowserNotificationListView(
            context,
            onOpen,
            onDelete
        )
    }

    fun createCleaner(
        context: Context
    ): BrowserNotificationCleaner {
        val repository = BrowserNotificationRepository(context)
        val settings = BrowserNotificationSettingsManager(context)

        return BrowserNotificationCleaner(
            repository,
            settings
        )
    }
}
