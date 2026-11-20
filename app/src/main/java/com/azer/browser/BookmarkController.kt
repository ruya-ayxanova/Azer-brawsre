
package com.azer.browser

import android.content.Context
import android.graphics.Color
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class BookmarkController(
    private val context: Context,
    private val onOpenUrl: (String) -> Unit
) : BookmarkCallbacks {

    private val storage = BookmarkStorage(context)
    private val repository = BookmarkRepository(storage)
    private val folderRepository = BookmarkFolderRepository(storage)
    private val settings = BookmarkSettings(context)

    private var selectedFolderId =
        BookmarkFolderRepository.DEFAULT_FOLDER_ID

    private var searchQuery = ""

    val root = LinearLayout(context).apply {
        orientation = LinearLayout.VERTICAL
        setBackgroundColor(Color.rgb(245, 247, 245))
    }

    private val folderView = BookmarkFolderListView(context) {
        onFolderSelected(it)
    }

    private val bookmarkView = BookmarkListView(
        context,
        { onBookmarkOpened(it) },
        { onBookmarkMenu(it) }
    )

    init {
        buildScreen()
        refresh()
    }

    private fun buildScreen() {
        val search = EditText(context).apply {
            hint = "Yer imlerinde ara"
            singleLine = true
            setPadding(16, 10, 16, 10)

            addTextChangedListener(
                object : android.text.TextWatcher {
                    override fun beforeTextChanged(
                        s: CharSequence?,
                        start: Int,
                        count: Int,
                        after: Int
                    ) {}

                    override fun onTextChanged(
                        s: CharSequence?,
                        start: Int,
                        before: Int,
                        count: Int
                    ) {
                        searchQuery = s?.toString().orEmpty()
                        refreshBookmarks()
                    }

                    override fun afterTextChanged(
                        s: android.text.Editable?
                    ) {}
                }
            )
        }

        val buttons = LinearLayout(context).apply {
            orientation = LinearLayout.HORIZONTAL
        }

        val addBookmark = Button(context).apply {
            text = "Yer imi ekle"
            setOnClickListener {
                onAddBookmarkRequested()
            }
        }

        val addFolder = Button(context).apply {
            text = "Klasör ekle"
            setOnClickListener {
                onAddFolderRequested()
            }
        }

        val sortButton = Button(context).apply {
            text = "Sırala"
            setOnClickListener {
                showSortMenu()
            }
        }

        buttons.addView(
            addBookmark,
            LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f)
        )
        buttons.addView(
            addFolder,
            LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f)
        )
        buttons.addView(
            sortButton,
            LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f)
        )

        root.addView(search)
        root.addView(buttons)

        if (settings.showFolders) {
            root.addView(folderView)
        }

        root.addView(
            bookmarkView,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                0,
                1f
            )
        )
    }

    fun refresh() {
        val folders = folderRepository.getAll()
        val bookmarks = repository.getAll()

        if (folders.none { it.id == selectedFolderId }) {
            selectedFolderId =
                BookmarkFolderRepository.DEFAULT_FOLDER_ID
        }

        folderView.showFolders(folders, bookmarks)
        refreshBookmarks()
    }

    private fun refreshBookmarks() {
        val sorted = BookmarkSearch.filterByFolder(
            repository.getAll(),
            selectedFolderId
        )

        val filtered = BookmarkSearch.filter(
            sorted,
            searchQuery
        )

        val result = when (settings.sortOrder) {
            BookmarkSortOrder.NEWEST ->
                filtered.sortedByDescending { it.createdAt }

            BookmarkSortOrder.OLDEST ->
                filtered.sortedBy { it.createdAt }

            BookmarkSortOrder.TITLE_ASCENDING ->
                filtered.sortedBy { it.title.lowercase() }

            BookmarkSortOrder.TITLE_DESCENDING ->
                filtered.sortedByDescending { it.title.lowercase() }
        }

        bookmarkView.showBookmarks(result)
    }

    override fun onBookmarkOpened(bookmark: Bookmark) {
        onOpenUrl(bookmark.url)
    }

    override fun onBookmarkEditRequested(bookmark: Bookmark) {
        BookmarkDialogHelper.showBookmarkDialog(
            context,
            "Yer imini düzenle",
            bookmark.title,
            bookmark.url
        ) { title, url ->
            if (repository.update(bookmark.id, title, url)) {
                refresh()
            } else {
                showMessage("Yer imi güncellenemedi.")
            }
        }
    }

    override fun onBookmarkDeleteRequested(bookmark: Bookmark) {
        AlertDialog.Builder(context)
            .setTitle("Yer imini sil")
            .setMessage("${bookmark.title} silinsin mi?")
            .setNegativeButton("İptal", null)
            .setPositiveButton("Sil") { _, _ ->
                repository.delete(bookmark.id)
                refresh()
            }
            .show()
    }

    override fun onBookmarkMoveRequested(bookmark: Bookmark) {
        val folders = folderRepository.getAll()

        val names = folders.map { it.name }.toTypedArray()

        AlertDialog.Builder(context)
            .setTitle("Klasör seç")
            .setItems(names) { _, which ->
                repository.moveToFolder(
                    bookmark.id,
                    folders[which].id
                )
                refresh()
            }
            .setNegativeButton("İptal", null)
            .show()
    }

    override fun onFolderSelected(folder: BookmarkFolder) {
        selectedFolderId = folder.id
        refreshBookmarks()
    }

    override fun onAddBookmarkRequested() {
        BookmarkDialogHelper.showBookmarkDialog(
            context,
            "Yeni yer imi"
        ) { title, url ->
            val result = repository.add(
                title,
                url,
                selectedFolderId
            )

            if (result == null) {
                showMessage("Yer imi eklenemedi. Adres zaten kayıtlı olabilir.")
            }

            refresh()
        }
    }

    override fun onAddFolderRequested() {
        BookmarkDialogHelper.showFolderDialog(context) { name ->
            if (folderRepository.add(name) != null) {
                refresh()
            } else {
                showMessage("Bu klasör adı zaten kullanılıyor.")
            }
        }
    }

    private fun onBookmarkMenu(bookmark: Bookmark) {
        BookmarkMenuHelper.show(
            context,
            bookmark,
            onEdit = { onBookmarkEditRequested(it) },
            onDelete = { onBookmarkDeleteRequested(it) },
            onMove = { onBookmarkMoveRequested(it) }
        )
    }

    private fun showSortMenu() {
        val options = arrayOf(
            "En yeni",
            "En eski",
            "İsme göre A-Z",
            "İsme göre Z-A"
        )

        AlertDialog.Builder(context)
            .setTitle("Yer imlerini sırala")
            .setItems(options) { _, which ->
                settings.sortOrder = BookmarkSortOrder.values()[which]
                refreshBookmarks()
            }
            .show()
    }

    private fun showMessage(message: String) {
        Toast.makeText(
            context,
            message,
            Toast.LENGTH_SHORT
        ).show()
    }

    fun exportBookmarks(): String {
        return BookmarkExportManager.export(repository.getAll())
    }

    fun importBookmarks(json: String): Int {
        val imported = BookmarkExportManager.import(json)
        var count = 0

        imported.forEach { item ->
            val result = repository.add(
                item.title,
                item.url,
                if (folderRepository.getAll().any {
                    it.id == item.folderId
                }) {
                    item.folderId
                } else {
                    BookmarkFolderRepository.DEFAULT_FOLDER_ID
                }
            )

            if (result != null) count++
        }

        refresh()
        return count
    }
}
