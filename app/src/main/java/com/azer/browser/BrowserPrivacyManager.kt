package com.azer.browser

import android.content.Context

class BrowserPrivacyManager(context: Context) {

    private val repository = BrowserPrivacyRepository(
        BrowserPrivacyStorage(context)
    )

    fun settings(): BrowserPrivacySettings {
        return repository.getSettings()
    }

    fun save(settings: BrowserPrivacySettings) {
        repository.update(settings)
    }

    fun setTrackingProtection(enabled: Boolean) {
        val old = settings()
        save(old.copy(trackingProtection = enabled))
    }

    fun setCookiesEnabled(enabled: Boolean) {
        val old = settings()
        save(old.copy(cookiesEnabled = enabled))
    }

    fun setJavaScriptEnabled(enabled: Boolean) {
        val old = settings()
        save(old.copy(javascriptEnabled = enabled))
    }

    fun setPrivateBrowsing(enabled: Boolean) {
        val old = settings()
        save(old.copy(privateBrowsing = enabled))
    }
}
