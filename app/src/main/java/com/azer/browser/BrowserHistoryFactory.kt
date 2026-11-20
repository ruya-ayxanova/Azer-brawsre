
package com.azer.browser

import android.content.Context

object BrowserHistoryFactory {

    fun createController(
        context: Context
    ): BrowserHistoryController {
        return BrowserHistoryController(context)
    }

    fun createRepository(
        context: Context
    ): BrowserHistoryRepository {
        return BrowserHistoryRepository(context)
    }

    fun createHistoryView(
        context: Context,
        onOpen: (BrowserHistoryEntry) -> Unit,
        onDelete: (BrowserHistoryEntry) -> Unit
    ): BrowserHistoryListView {

        return BrowserHistoryListView(
            context,
            onOpen,
            onDelete
        )
    }
}
