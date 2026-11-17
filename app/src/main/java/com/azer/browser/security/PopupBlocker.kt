
package com.azer.browser.security

import android.webkit.WebSettings

object PopupBlocker {

    fun configure(settings: WebSettings) {
        settings.javaScriptCanOpenWindowsAutomatically = false
        settings.setSupportMultipleWindows(false)
    }
}
