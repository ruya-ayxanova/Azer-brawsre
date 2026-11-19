
package com.azer.browser

interface TabWebViewCallbacks {
    fun onPageStarted(tabId: String, url: String)
    fun onPageFinished(tabId: String, url: String)
    fun onPageTitleChanged(tabId: String, title: String)
    fun onPageProgress(tabId: String, progress: Int)
}
