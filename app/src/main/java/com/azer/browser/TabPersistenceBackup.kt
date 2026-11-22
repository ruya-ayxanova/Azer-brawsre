package com.azer.browser

data class TabPersistenceBackup(
    val version: Int,
    val backupDate: Long,
    val jsonData: String
)
