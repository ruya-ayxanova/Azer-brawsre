package com.azer.browser

object BrowserTabUtils {

    fun isBlank(tab: BrowserTab): Boolean {
        return tab.url.isBlank()
    }

    fun isPrivate(tab: BrowserTab): Boolean {
        return tab.title == "Gizli sekme"
    }

    fun displayTitle(tab: BrowserTab): String {
        return tab.title.ifBlank {
            BrowserTabLimits.DEFAULT_TITLE
        }
    }

    fun displayUrl(tab: BrowserTab): String {
        return tab.url.ifBlank {
            "Henüz adres girilmedi"
        }
    }
}
