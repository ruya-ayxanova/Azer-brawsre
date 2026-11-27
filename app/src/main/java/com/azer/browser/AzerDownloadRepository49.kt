class AzerDownloadRepository49 {

    private val downloads =
        mutableMapOf<String, AzerDownloadItem49>()

    fun insert(item: AzerDownloadItem49) {
        downloads[item.id] = item
    }

    fun update(item: AzerDownloadItem49) {
        if (downloads.containsKey(item.id)) {
            downloads[item.id] = item
        }
    }

    fun get(id: String): AzerDownloadItem49? {
        return downloads[id]
    }

    fun getAll(): List<AzerDownloadItem49> {
        return downloads.values.toList()
    }

    fun delete(id: String) {
        downloads.remove(id)
    }

    fun clear() {
        downloads.clear()
    }
}
