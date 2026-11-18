package com.azer.browser.ui.navigation

interface BrowserPageListener {
    fun onPageStarted(url: String)
    fun onPageFinished(url: String, title: String)
    fun onProgressChanged(progress: Int)
    fun onPageError(url: String, message: String)
}
