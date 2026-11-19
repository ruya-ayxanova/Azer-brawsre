
package com.azer.browser

interface BrowserTabListener {

    fun onTabSelected(tab: BrowserTab)

    fun onTabClosed(tab: BrowserTab)

    fun onNewTabRequested()
}
