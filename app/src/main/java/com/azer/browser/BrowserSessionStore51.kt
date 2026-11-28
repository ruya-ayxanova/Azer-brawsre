package com.azer.browser

interface BrowserSessionStore51 {

    fun save(session: BrowserSession51)

    fun get(sessionId: String): BrowserSession51?

    fun getAll(): List<BrowserSession51>

    fun remove(sessionId: String)

    fun clear()
}
