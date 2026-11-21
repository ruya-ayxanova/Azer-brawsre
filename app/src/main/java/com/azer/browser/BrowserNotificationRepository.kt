package com.azer.browser

import android.content.Context
import java.util.UUID

class BrowserNotificationRepository(context: Context) {

    private val storage = BrowserNotificationStorage(context)
    private val items = BrowserNotificationJsonCodec
        .decode(storage.load())
        .toMutableList()

    @Synchronized
    fun getAll(): List<BrowserNotification> {
        return items.sortedByDescending { it.createdAt }
    }

    @Synchronized
    fun add(
        title: String,
        message: String,
        host: String
    ): BrowserNotification {

        val item = BrowserNotification(
            id = UUID.randomUUID().toString(),
            title = title,
            message = message,
            host = host
        )

        items.add(item)
        save()

        return item
    }

    @Synchronized
    fun markRead(id: String) {
        val index = items.indexOfFirst { it.id == id }

        if (index >= 0) {
            items[index] = items[index].copy(read = true)
            save()
        }
    }

    @Synchronized
    fun delete(id: String) {
        items.removeAll { it.id == id }
        save()
    }

    @Synchronized
    fun clear() {
        items.clear()
        storage.clear()
    }

    @Synchronized
    fun unreadCount(): Int {
        return items.count { !it.read }
    }

    @Synchronized
    private fun save() {
        storage.save(
            BrowserNotificationJsonCodec.encode(items)
        )
    }
}
