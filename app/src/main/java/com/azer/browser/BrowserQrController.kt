package com.azer.browser

import android.content.Context

class BrowserQrController(context: Context) {

    private val history = BrowserQrHistoryManager(context)
    private val settings = BrowserQrSettingsManager(context)
    private val scanner = BrowserQrScannerController()

    fun parse(value: String): BrowserQrScanResult {
        val result = scanner.processResult(value)

        if (settings.get().saveHistory && result.valid) {
            history.save(value)
        }

        return result
    }

    fun getSettings(): BrowserQrSettings {
        return settings.get()
    }

    fun updateSettings(value: BrowserQrSettings) {
        settings.update(value)
    }

    fun getHistory(): List<BrowserQrHistoryItem> {
        return history.getHistory()
    }

    fun deleteHistoryItem(content: String) {
        history.delete(content)
    }

    fun clearHistory() {
        history.clear()
    }

    fun startScanner() {
        scanner.start()
    }

    fun stopScanner() {
        scanner.stop()
    }

    fun isScanning(): Boolean {
        return scanner.isScanning
    }
}
