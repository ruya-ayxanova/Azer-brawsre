package com.azer.browser

import android.view.View
import android.webkit.WebView

object BrowserWebTabSwitcher39 {

    fun activate(
        target: WebView,
        allViews: Collection<WebView>
    ) {
        allViews.forEach {
            it.visibility = View.GONE
        }

        target.visibility = View.VISIBLE
        target.requestFocus()
    }

    fun deactivate(
        webView: WebView
    ) {
        webView.visibility = View.GONE
    }
}
