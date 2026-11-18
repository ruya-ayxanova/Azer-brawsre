package com.azer.browser.ui.tabs

import android.webkit.WebView

class BrowserTabRegistry {

    private val webViews = mutableListOf<WebView>()
    private val urls = mutableListOf<String>()
    private val titles = mutableListOf<String>()

    private var activeIndex = 0

    val count: Int
        get() = webViews.size

    fun add(webView: WebView, url: String = "azer://home"): Int {
        webViews.add(webView)
        urls.add(url)
        titles.add("Yeni Sekme")
        activeIndex = webViews.lastIndex
        return activeIndex
    }

    fun getActive(): WebView? {
        return webViews.getOrNull(activeIndex)
    }

    fun get(index: Int): WebView? {
        return webViews.getOrNull(index)
    }

    fun getUrl(index: Int): String {
        return urls.getOrNull(index) ?: ""
    }

    fun getTitle(index: Int): String {
        return titles.getOrNull(index) ?: "Sekme"
    }

    fun setUrl(index: Int, url: String) {
        if (index in urls.indices) {
            urls[index] = url
        }
    }

    fun setTitle(index: Int, title: String) {
        if (index in titles.indices && title.isNotBlank()) {
            titles[index] = title
        }
    }

    fun activate(index: Int): WebView? {
        if (index !in webViews.indices) return null
        activeIndex = index
        return webViews[index]
    }

    fun activeIndex(): Int = activeIndex

    fun entries(): List<BrowserTabEntry> {
        return webViews.indices.map { index ->
            BrowserTabEntry(
                id = index,
                title = titles[index],
                url = urls[index],
                isActive = index == activeIndex
            )
        }
    }

    fun close(index: Int): WebView? {
        if (index !in webViews.indices) return null

        val removed = webViews.removeAt(index)
        urls.removeAt(index)
        titles.removeAt(index)

        if (webViews.isEmpty()) {
            activeIndex = 0
        } else if (activeIndex >= webViews.size) {
            activeIndex = webViews.lastIndex
        } else if (index < activeIndex) {
            activeIndex--
        }

        return removed
    }

    fun clear() {
        webViews.forEach {
            it.stopLoading()
            it.destroy()
        }
        webViews.clear()
        urls.clear()
        titles.clear()
        activeIndex = 0
    }
}
