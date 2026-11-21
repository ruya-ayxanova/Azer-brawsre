package com.azer.browser

object SitePermissionSummaryBuilder {

    fun build(
        host: String,
        records: List<SitePermissionRecord>
    ): SitePermissionSummary {

        val items = records.filter {
            it.host.equals(host, true)
        }

        return SitePermissionSummary(
            host = host,
            allowedCount = items.count {
                it.action == SitePermissionAction.ALLOW
            },
            blockedCount = items.count {
                it.action == SitePermissionAction.BLOCK
            },
            askCount = items.count {
                it.action == SitePermissionAction.ASK
            }
        )
    }
}
