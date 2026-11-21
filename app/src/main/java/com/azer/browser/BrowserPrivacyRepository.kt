package com.azer.browser

class BrowserPrivacyRepository(
    private val storage: BrowserPrivacyStorage
) {

    fun getSettings(): BrowserPrivacySettings {
        return BrowserPrivacySettings(
            trackingProtection = storage.getBoolean(
                BrowserPrivacyKeys.TRACKING, true
            ),
            blockThirdPartyCookies = storage.getBoolean(
                BrowserPrivacyKeys.THIRD_PARTY, true
            ),
            javascriptEnabled = storage.getBoolean(
                BrowserPrivacyKeys.JAVASCRIPT, true
            ),
            cookiesEnabled = storage.getBoolean(
                BrowserPrivacyKeys.COOKIES, true
            ),
            safeBrowsing = storage.getBoolean(
                BrowserPrivacyKeys.SAFE_BROWSING, true
            ),
            privateBrowsing = storage.getBoolean(
                BrowserPrivacyKeys.PRIVATE_MODE, false
            ),
            doNotTrack = storage.getBoolean(
                BrowserPrivacyKeys.DNT, true
            )
        )
    }

    fun update(settings: BrowserPrivacySettings) {
        storage.setBoolean(BrowserPrivacyKeys.TRACKING, settings.trackingProtection)
        storage.setBoolean(BrowserPrivacyKeys.THIRD_PARTY, settings.blockThirdPartyCookies)
        storage.setBoolean(BrowserPrivacyKeys.JAVASCRIPT, settings.javascriptEnabled)
        storage.setBoolean(BrowserPrivacyKeys.COOKIES, settings.cookiesEnabled)
        storage.setBoolean(BrowserPrivacyKeys.SAFE_BROWSING, settings.safeBrowsing)
        storage.setBoolean(BrowserPrivacyKeys.PRIVATE_MODE, settings.privateBrowsing)
        storage.setBoolean(BrowserPrivacyKeys.DNT, settings.doNotTrack)
    }
}
