package com.azer.browser

interface BrowserEngineAdapter51 {

    fun loadUrl(url: String)

    fun reload()

    fun stopLoading()

    fun goBack(): Boolean

    fun goForward(): Boolean

    fun currentUrl(): String?

    fun isLoading(): Boolean
}
