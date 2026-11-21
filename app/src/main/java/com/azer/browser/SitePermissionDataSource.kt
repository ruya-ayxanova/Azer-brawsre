package com.azer.browser

class SitePermissionDataSource(
    private val storage: SitePermissionLocalStorage
) {

    fun getRecords(): List<SitePermissionRecord> {
        return SitePermissionJsonCodec.decode(storage.read())
    }

    fun saveRecords(records: List<SitePermissionRecord>) {
        storage.write(
            SitePermissionJsonCodec.encode(records)
        )
    }

    fun clear() {
        storage.clear()
    }
}
