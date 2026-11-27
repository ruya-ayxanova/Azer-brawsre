class AzerDownloadHistory49 {

    private val items =
        mutableListOf<AzerDownloadItem49>()

    fun record(item: AzerDownloadItem49) {
        items.removeAll { it.id == item.id }
        items.add(item)
    }

    fun getAll(): List<AzerDownloadItem49> {
        return items.sortedByDescending { it.createdAt }
    }

    fun remove(id: String) {
        items.removeAll { it.id == id }
    }

    fun clear() {
        items.clear()
    }
}
