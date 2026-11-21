package com.azer.browser

import android.content.Context
import androidx.appcompat.app.AlertDialog

object SitePermissionMenu {

    fun show(
        context: Context,
        host: String,
        controller: SitePermissionControllerV29,
        onChanged: () -> Unit
    ) {
        val types = BrowserPermissionType.values()

        val names = types.map {
            SitePermissionFormatter.permissionName(it)
        }.toTypedArray()

        AlertDialog.Builder(context)
            .setTitle(host)
            .setItems(names) { _, index ->
                val type = types[index]

                val record = SitePermissionRecord(
                    host = host,
                    type = type,
                    action = controller.get(host, type)
                )

                SitePermissionDialog.show(
                    context,
                    record
                ) { action ->
                    controller.set(
                        host,
                        type,
                        action
                    )

                    onChanged()
                }
            }
            .setNeutralButton("Site izinlerini sıfırla") { _, _ ->
                controller.removeSite(host)
                onChanged()
            }
            .setNegativeButton("Kapat", null)
            .show()
    }
}
