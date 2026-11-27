class AzerDownloadQueue49 {

    private val items =
        mutableListOf<AzerDownloadItem49>()

    fun add(item: AzerDownloadItem49) {
        if (items.none { it.id == item.id }) {
            items.add(item)
        }
    }

    fun remove(id: String) {
        items.removeAll { it.id == id }
    }

    fun nextPending(): AzerDownloadItem49? {
        return items.firstOrNull {
            it.status == AzerDownloadStatus49.PENDING
        }
    }

    fun getAll(): List<AzerDownloadItem49> {
        return items.toList()
    }

    fun clear() {
        items.clear()
    }

    fun size(): Int {
        return items.size
    }
}
