package com.azer.browser

object TabClosePolicy38 {

    fun shouldConfirm(tab: BrowserTab): Boolean {
        return tab.isLoading
    }

    fun canClose(tab: BrowserTab?): Boolean {
        return tab != null && tab.id.isNotBlank()
    }
}
