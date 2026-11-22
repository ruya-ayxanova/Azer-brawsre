package com.azer.browser

object TabPersistenceBackupBuilder {

    fun create(
        tabs: List<BrowserTab>
    ): TabPersistenceBackup {

        val snapshot =
            TabPersistenceSnapshotFactory.create(tabs)

        val json =
            TabPersistenceJsonEncoder.encode(snapshot)

        return TabPersistenceBackup(
            version = TabPersistenceConstants.VERSION,
            backupDate = System.currentTimeMillis(),
            jsonData = json
        )
    }

    fun toJson(
        backup: TabPersistenceBackup
    ): String {

        val root = org.json.JSONObject()

        root.put("backupVersion", backup.version)
        root.put("backupDate", backup.backupDate)
        root.put("data", backup.jsonData)

        return root.toString()
    }
}
