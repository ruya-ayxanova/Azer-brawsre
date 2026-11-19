
package com.azer.browser

interface BrowserToolbarCallbacks {
    fun onAddressSubmitted(value: String)
    fun onBackClicked()
    fun onForwardClicked()
    fun onReloadClicked()
    fun onHomeClicked()
    fun onShareClicked(url: String)
    fun onCopyClicked(url: String)
}
