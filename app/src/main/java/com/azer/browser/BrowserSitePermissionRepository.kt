package com.azer.browser

class BrowserSitePermissionRepository(
    private val storage: BrowserSitePermissionStorage
) {

    private val items = storage.load().toMutableList()

    @Synchronized
    fun getAll(): List<BrowserSitePermission> {
        return items.toList()
    }

    @Synchronized
    fun setPermission(
        host: String,
        permission: BrowserPermissionType,
        allowed: Boolean
    ) {
        items.removeAll {
            it.host.equals(host, true) &&
                it.permission == permission
        }

        items.add(
            BrowserSitePermission(
                host = host.lowercase(),
                permission = permission,
                allowed = allowed
            )
        )

        storage.save(items)
    }

    @Synchronized
    fun find(
        host: String,
        permission: BrowserPermissionType
    ): BrowserSitePermission? {
        return items.firstOrNull {
            it.host.equals(host, true) &&
                it.permission == permission
        }
    }

    @Synchronized
    fun removeHost(host: String) {
        items.removeAll {
            it.host.equals(host, true)
        }

        storage.save(items)
    }

    @Synchronized
    fun clear() {
        items.clear()
        storage.clear()
    }
}
