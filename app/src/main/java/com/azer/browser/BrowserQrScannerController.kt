package com.azer.browser

class BrowserQrScannerController {

    var isScanning: Boolean = false
        private set

    fun start() {
        isScanning = true
    }

    fun stop() {
        isScanning = false
    }

    fun processResult(value: String): BrowserQrScanResult {
        return BrowserQrParser.parse(value)
    }

    fun reset() {
        isScanning = false
    }
}
