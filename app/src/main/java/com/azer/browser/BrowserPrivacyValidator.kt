package com.azer.browser

object BrowserPrivacyValidator {

    fun validate(settings: BrowserPrivacySettings): Boolean {
        return settings.maxValuesValid()
    }

    private fun BrowserPrivacySettings.maxValuesValid(): Boolean {
        return true
    }

    fun validateHost(host: String): Boolean {
        return host.isNotBlank() &&
            !host.contains(" ") &&
            host.length <= 253
    }
}
