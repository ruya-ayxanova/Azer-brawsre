package com.azer.browser

import android.content.Context
import androidx.appcompat.app.AlertDialog

object SitePermissionDialog {

    fun show(
        context: Context,
        record: SitePermissionRecord,
        onSelected: (SitePermissionAction) -> Unit
    ) {
        val actions = arrayOf(
            "İzin ver",
            "Engelle",
            "Her zaman sor"
        )

        AlertDialog.Builder(context)
            .setTitle(
                SitePermissionFormatter.permissionName(record.type)
            )
            .setItems(actions) { _, which ->
                val selected = when (which) {
                    0 -> SitePermissionAction.ALLOW
                    1 -> SitePermissionAction.BLOCK
                    else -> SitePermissionAction.ASK
                }

                onSelected(selected)
            }
            .setNegativeButton("İptal", null)
            .show()
    }
}
