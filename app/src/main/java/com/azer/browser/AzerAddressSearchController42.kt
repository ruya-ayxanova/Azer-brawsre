package com.azer.browser

import android.webkit.WebView

class AzerAddressSearchController42(
    private val webView: WebView
) {

    private val searchManager =
        AzerSearchManager42()

    private val actionHandler =
        AzerAddressActionHandler42(searchManager)

    private val history =
        AzerSearchHistoryManager42()

    fun submit(input: String): Boolean {
        val text = input.trim()

        if (text.isEmpty()) return false

        val target = actionHandler.handle(text)

        if (target.isEmpty()) return false

        webView.loadUrl(target)

        history.add(text, target)

        return true
    }

    fun changeSearchProvider(
        provider: AzerSearchProvider42
    ) {
        searchManager.setProvider(provider)
    }

    fun getSearchHistory():
        List<AzerSearchHistoryItem42> {
        return history.getHistory()
    }

    fun clearSearchHistory() {
        history.clear()
    }
}
