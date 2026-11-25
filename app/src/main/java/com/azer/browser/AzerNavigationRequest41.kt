package com.azer.browser

data class AzerNavigationRequest41(
    val url: String,
    val tabId: String? = null,
    val timestamp: Long = System.currentTimeMillis(),
    val fromSearch: Boolean = false
)
