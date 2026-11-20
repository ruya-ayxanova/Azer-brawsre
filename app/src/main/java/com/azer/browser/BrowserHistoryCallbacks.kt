
package com.azer.browser

interface BrowserHistoryCallbacks {

    fun onHistoryItemClicked(entry: BrowserHistoryEntry)

    fun onHistoryItemDeleted(entry: BrowserHistoryEntry)

    fun onHistoryCleared()

    fun onHistoryChanged(entries: List<BrowserHistoryEntry>) {}
}
