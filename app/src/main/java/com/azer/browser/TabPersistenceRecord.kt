package com.azer.browser

data class TabPersistenceRecord(
    val id: String,
    val title: String,
    val url: String,
    val isActive: Boolean,
    val createdAt: Long,
    val lastAccessedAt: Long
)
