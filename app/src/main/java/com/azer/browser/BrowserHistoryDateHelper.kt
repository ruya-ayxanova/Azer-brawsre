
package com.azer.browser

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object BrowserHistoryDateHelper {

    fun formatDate(timestamp: Long): String {
        return SimpleDateFormat(
            "yyyy/MM/dd",
            Locale.getDefault()
        ).format(Date(timestamp))
    }

    fun formatTime(timestamp: Long): String {
        return SimpleDateFormat(
            "HH:mm",
            Locale.getDefault()
        ).format(Date(timestamp))
    }

    fun formatFull(timestamp: Long): String {
        return SimpleDateFormat(
            "yyyy/MM/dd HH:mm",
            Locale.getDefault()
        ).format(Date(timestamp))
    }

    fun todayStart(): Long {
        val calendar = java.util.Calendar.getInstance()
        calendar.set(java.util.Calendar.HOUR_OF_DAY, 0)
        calendar.set(java.util.Calendar.MINUTE, 0)
        calendar.set(java.util.Calendar.SECOND, 0)
        calendar.set(java.util.Calendar.MILLISECOND, 0)
        return calendar.timeInMillis
    }
}
