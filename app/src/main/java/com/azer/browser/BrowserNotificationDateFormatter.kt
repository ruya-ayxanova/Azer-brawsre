package com.azer.browser

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object BrowserNotificationDateFormatter {

    fun format(timestamp: Long): String {
        return SimpleDateFormat(
            "dd.MM.yyyy HH:mm",
            Locale.getDefault()
        ).format(Date(timestamp))
    }

    fun formatTime(timestamp: Long): String {
        return SimpleDateFormat(
            "HH:mm",
            Locale.getDefault()
        ).format(Date(timestamp))
    }
}
