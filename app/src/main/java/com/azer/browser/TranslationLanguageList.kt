package com.azer.browser

object TranslationLanguageList {

    val languages = listOf(
        TranslationLanguage("auto", "Otomatik algıla"),
        TranslationLanguage("tr", "Türkçe"),
        TranslationLanguage("az", "Azerbaycanca"),
        TranslationLanguage("fa", "Farsça"),
        TranslationLanguage("en", "İngilizce"),
        TranslationLanguage("ar", "Arapça"),
        TranslationLanguage("ru", "Rusça"),
        TranslationLanguage("de", "Almanca"),
        TranslationLanguage("fr", "Fransızca"),
        TranslationLanguage("es", "İspanyolca"),
        TranslationLanguage("it", "İtalyanca"),
        TranslationLanguage("zh", "Çince"),
        TranslationLanguage("ja", "Japonca"),
        TranslationLanguage("ko", "Korece"),
        TranslationLanguage("pt", "Portekizce"),
        TranslationLanguage("nl", "Felemenkçe"),
        TranslationLanguage("el", "Yunanca"),
        TranslationLanguage("hi", "Hintçe"),
        TranslationLanguage("ur", "Urduca"),
        TranslationLanguage("uk", "Ukraynaca")
    )

    fun find(code: String): TranslationLanguage? {
        return languages.find { it.code == code }
    }
}
