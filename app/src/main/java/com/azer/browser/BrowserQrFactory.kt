package com.azer.browser

import android.content.Context

object BrowserQrFactory {

    fun createController(context: Context): BrowserQrController {
        return BrowserQrController(context)
    }

    fun createHistory(context: Context): BrowserQrHistoryManager {
        return BrowserQrHistoryManager(context)
    }

    fun createSettings(context: Context): BrowserQrSettingsManager {
        return BrowserQrSettingsManager(context)
    }

    fun createScanner(): BrowserQrScannerController {
        return BrowserQrScannerController()
    }

    fun parse(value: String): BrowserQrScanResult {
        return BrowserQrParser.parse(value)
    }

    fun detectType(value: String): BrowserQrType {
        return BrowserQrParser.detectType(value)
    }
}
