package com.azer.browser

class SitePermissionRepositoryV29(
    private val dataSource: SitePermissionDataSource
) {

    private val records = dataSource.getRecords().toMutableList()

    @Synchronized
    fun getAll(): List<SitePermissionRecord> {
        return records.toList()
    }

    @Synchronized
    fun getForHost(host: String): List<SitePermissionRecord> {
        return records.filter {
            it.host.equals(host, ignoreCase = true)
        }
    }

    @Synchronized
    fun get(
        host: String,
        type: BrowserPermissionType
    ): SitePermissionRecord? {
        return records.find {
            it.host.equals(host, ignoreCase = true) &&
                it.type == type
        }
    }

    @Synchronized
    fun set(
        host: String,
        type: BrowserPermissionType,
        action: SitePermissionAction
    ) {
        val normalized = SitePermissionHostUtils.normalize(host)

        records.removeAll {
            it.host == normalized && it.type == type
        }

        records.add(
            SitePermissionRecord(
                host = normalized,
                type = type,
                action = action
            )
        )

        dataSource.saveRecords(records)
    }

    @Synchronized
    fun removeHost(host: String) {
        records.removeAll {
            it.host.equals(host, true)
        }

        dataSource.saveRecords(records)
    }

    @Synchronized
    fun clear() {
        records.clear()
        dataSource.clear()
    }
}
