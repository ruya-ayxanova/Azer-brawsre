package com.azer.browser

interface BrowserQrCallbacks {

    fun onQrDetected(result: BrowserQrScanResult)

    fun onQrError(message: String)

    fun onQrHistoryUpdated(items: List<BrowserQrHistoryItem>)
}
