package com.azer.browser.ui.bookmarks

import android.webkit.WebView

class BookmarkAction(
    private val store: BookmarkStore
) {

    fun saveCurrentPage(webView: WebView?): Boolean {
        if (webView == null) return false

        val url = webView.url ?: return false

        if (!BookmarkUrlValidator.isValid(url)) {
            return false
        }

        val title = webView.title ?: url

        return store.add(title, url)
    }

    fun isBookmarked(webView: WebView?): Boolean {
        val url = webView?.url ?: return false
        return store.contains(url)
    }
}
