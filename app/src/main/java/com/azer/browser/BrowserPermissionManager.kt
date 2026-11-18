package com.azer.browser

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

object BrowserPermissionManager {

    const val NOTIFICATION_REQUEST = 501

    fun requestNotificationPermission(activity: Activity) {

        if (Build.VERSION.SDK_INT >= 33) {

            val permission = Manifest.permission.POST_NOTIFICATIONS

            if (ContextCompat.checkSelfPermission(
                    activity,
                    permission
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    activity,
                    arrayOf(permission),
                    NOTIFICATION_REQUEST
                )
            }
        }
    }
}
