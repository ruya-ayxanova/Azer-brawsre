
package com.azer.browser

import android.content.Context
import java.util.UUID

class BrowserHistoryRepository(context: Context) {

    private val storage = BrowserHistoryStorage(context)

    private val entries = mutableListOf<BrowserHistoryEntry>()

    init {
        entries.addAll(
            BrowserHistoryJson.decode(storage.load())
        )
    }

    @Synchronized
    fun getAll(): List<BrowserHistoryEntry> {
        return entries.sortedByDescending { it.visitedAt }
    }

    @Synchronized
    fun add(title: String, url: String): BrowserHistoryEntry? {
        if (!BrowserHistoryValidator.isValidUrl(url)) {
            return null
        }

        val entry = BrowserHistoryEntry(
            id = UUID.randomUUID().toString(),
            title = BrowserHistoryValidator.cleanTitle(title),
            url = url,
            visitedAt = System.currentTimeMillis()
        )

        entries.add(entry)
        save()

        return entry
    }

    @Synchronized
    fun delete(id: String): Boolean {
        val removed = entries.removeAll { it.id == id }

        if (removed) save()

        return removed
    }

    @Synchronized
    fun clear() {
        entries.clear()
        storage.clear()
    }

    @Synchronized
    fun count(): Int {
        return entries.size
    }

    @Synchronized
    fun save() {
        storage.save(
            BrowserHistoryJson.encode(entries)
        )
    }
}
