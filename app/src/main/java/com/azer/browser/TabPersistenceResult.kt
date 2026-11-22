package com.azer.browser

data class TabPersistenceResult(
    val success: Boolean,
    val message: String,
    val tabCount: Int = 0
)
