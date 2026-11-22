package com.azer.browser

interface TranslationProvider {

    suspend fun translate(
        request: TranslationRequest
    ): TranslationResult
}
