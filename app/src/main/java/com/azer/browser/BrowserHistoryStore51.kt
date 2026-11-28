package com.azer.browser

interface BrowserHistoryStore51 {

    fun add(entry: BrowserHistoryEntry51)

    fun getAll(): List<BrowserHistoryEntry51>

    fun remove(url: String)

    fun clear()

    fun size(): Int
}
