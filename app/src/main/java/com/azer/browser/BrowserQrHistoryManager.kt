package com.azer.browser

import android.content.Context

class BrowserQrHistoryManager(context: Context) {

    private val repository = BrowserQrHistoryRepository(context)

    fun save(value: String) {
        if (!BrowserQrValidator.isValidContent(value)) return

        repository.add(
            BrowserQrHistoryItem(
                content = value,
                type = BrowserQrParser.detectType(value)
            )
        )
    }

    fun getHistory(): List<BrowserQrHistoryItem> {
        return repository.getAll()
    }

    fun delete(value: String) {
        repository.delete(value)
    }

    fun clear() {
        repository.clear()
    }
}
