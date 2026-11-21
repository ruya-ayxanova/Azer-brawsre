package com.azer.browser

import android.content.Context
import android.widget.LinearLayout

class SitePermissionListView(
    context: Context,
    private val onClick: (SitePermissionRecord) -> Unit
) : LinearLayout(context) {

    init {
        orientation = VERTICAL
    }

    fun submit(records: List<SitePermissionRecord>) {
        removeAllViews()

        records.forEach { record ->
            val item = SitePermissionItemView(
                context,
                onClick
            )

            item.bind(record)

            addView(
                item,
                LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT
                )
            )
        }
    }
}
