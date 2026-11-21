package com.azer.browser

import android.content.Context

class ReaderModePreferences(context: Context) {

    private val prefs = context.getSharedPreferences(
        "azer_reader_preferences",
        Context.MODE_PRIVATE
    )

    fun getFontSize(): Int =
        prefs.getInt("font_size", 18)

    fun setFontSize(size: Int) {
        prefs.edit().putInt("font_size", size.coerceIn(12, 36)).apply()
    }

    fun getLineSpacing(): Float =
        prefs.getFloat("line_spacing", 1.5f)

    fun setLineSpacing(value: Float) {
        prefs.edit().putFloat("line_spacing", value.coerceIn(1f, 2.5f)).apply()
    }

    fun isDarkMode(): Boolean =
        prefs.getBoolean("dark_mode", false)

    fun setDarkMode(value: Boolean) {
        prefs.edit().putBoolean("dark_mode", value).apply()
    }

    fun isSerifFont(): Boolean =
        prefs.getBoolean("serif_font", false)

    fun setSerifFont(value: Boolean) {
        prefs.edit().putBoolean("serif_font", value).apply()
    }

    fun getSettings(): ReaderModeSettings {
        return ReaderModeSettings(
            fontSize = getFontSize(),
            lineSpacing = getLineSpacing(),
            darkMode = isDarkMode(),
            serifFont = isSerifFont()
        )
    }
}
