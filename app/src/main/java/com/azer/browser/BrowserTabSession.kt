
package com.azer.browser

import android.content.Context

class BrowserTabSession(context: Context) {

    val manager = BrowserTabManager(context)

    fun openNewTab(): BrowserTab {
        return manager.addTab()
    }

    fun openUrlInNewTab(
        title: String,
        url: String
    ): BrowserTab {
        return manager.addTab(title, url)
    }

    fun select(id: String): BrowserTab? {
        return manager.selectTab(id)
    }

    fun close(id: String): BrowserTab? {
        return manager.closeTab(id)
    }

    fun update(
        id: String,
        title: String,
        url: String
    ) {
        manager.updateTab(id, title, url)
    }

    fun getAll(): List<BrowserTab> {
        return manager.getTabs()
    }

    fun getCurrent(): BrowserTab? {
        return manager.getActiveTab()
    }
}
