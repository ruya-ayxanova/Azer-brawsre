
package com.azer.browser.adblock

class BlockedRequestCounter {

    private var count = 0

    @Synchronized
    fun addBlockedRequest() {
        count++
    }

    @Synchronized
    fun getCount(): Int {
        return count
    }

    @Synchronized
    fun reset() {
        count = 0
    }
}
