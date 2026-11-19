
package com.azer.browser

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.webkit.WebView

class TabWebViewRepository(
    private val context: Context,
    private val container: FrameLayout,
    private val callbacks: TabWebViewCallbacks
) {

    private val webViews = linkedMapOf<String, WebView>()

    fun getOrCreate(tabId: String): WebView {
        return webViews[tabId] ?: run {
            val webView = TabWebViewFactory.create(
                context,
                tabId,
                callbacks
            )

            webViews[tabId] = webView

            container.addView(
                webView,
                FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            )

            webView.visibility = View.GONE
            webView
        }
    }

    fun show(tabId: String): WebView {
        val selected = getOrCreate(tabId)

        webViews.forEach { (id, webView) ->
            webView.visibility = if (id == tabId) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }

        selected.requestFocus()
        return selected
    }

    fun remove(tabId: String) {
        val webView = webViews.remove(tabId) ?: return

        container.removeView(webView)
        webView.stopLoading()
        webView.loadUrl("about:blank")
        webView.clearHistory()
        webView.removeAllViews()
        webView.destroy()
    }

    fun find(tabId: String): WebView? {
        return webViews[tabId]
    }

    fun goBack(tabId: String): Boolean {
        val webView = webViews[tabId] ?: return false

        if (webView.canGoBack()) {
            webView.goBack()
            return true
        }

        return false
    }

    fun destroyAll() {
        webViews.keys.toList().forEach { remove(it) }
    }
}
