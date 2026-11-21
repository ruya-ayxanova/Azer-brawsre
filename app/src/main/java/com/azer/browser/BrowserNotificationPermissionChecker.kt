package com.azer.browser

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build

object BrowserNotificationPermissionChecker {

    fun isSystemPermissionGranted(context: Context): Boolean {
        if (Build.VERSION.SDK_INT < 33) return true

        return context.checkSelfPermission(
            Manifest.permission.POST_NOTIFICATIONS
        ) == PackageManager.PERMISSION_GRANTED
    }

    fun isSupported(): Boolean {
        return Build.VERSION.SDK_INT >= 26
    }
}
