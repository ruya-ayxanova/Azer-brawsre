package com.azer.browser

import android.content.Context
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView

class SitePermissionItemView(
    context: Context,
    private val onClick: (SitePermissionRecord) -> Unit
) : LinearLayout(context) {

    init {
        orientation = VERTICAL
        gravity = Gravity.CENTER_VERTICAL
        setPadding(16, 12, 16, 12)
    }

    fun bind(record: SitePermissionRecord) {
        removeAllViews()

        val title = TextView(context)
        title.text = SitePermissionFormatter.permissionName(record.type)
        title.textSize = 16f

        val status = TextView(context)
        status.text = SitePermissionFormatter.actionName(record.action)
        status.textSize = 13f

        addView(title)
        addView(status)

        setOnClickListener {
            onClick(record)
        }
    }
}
