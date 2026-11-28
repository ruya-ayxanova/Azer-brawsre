package com.azer.browser

data class BrowserCachePolicy51(
    val enabled: Boolean = true,
    val maxCacheSize: Long = 50L * 1024L * 1024L,
    val allowDiskCache: Boolean = true,
    val allowMemoryCache: Boolean = true
) {

    fun isCacheEnabled(): Boolean {
        return enabled &&
                (allowDiskCache || allowMemoryCache)
    }

    fun getMaximumSize(): Long {
        return maxCacheSize.coerceAtLeast(0L)
    }
}
