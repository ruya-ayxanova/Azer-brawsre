package com.azer.browser

object TranslationValidator {

    fun isValidLanguage(code: String): Boolean {
        return TranslationLanguageList.languages.any {
            it.code == code
        }
    }

    fun isValidText(text: String): Boolean {
        return text.trim().isNotEmpty()
    }

    fun validateRequest(request: TranslationRequest): Boolean {
        return isValidText(request.text) &&
                isValidLanguage(request.targetLanguage) &&
                isValidLanguage(request.sourceLanguage)
    }

    fun validateTarget(code: String): String {
        return if (isValidLanguage(code) && code != "auto") {
            code
        } else {
            "tr"
        }
    }
}
