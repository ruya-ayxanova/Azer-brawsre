package com.azer.browser

import android.content.Context
import android.view.View
import androidx.appcompat.app.AlertDialog

class BookmarkController(
    private val context: Context,
    private val repository: BookmarkRepository,
    private val folderRepository: BookmarkFolderRepository
) {

    private var currentFolderId: String = "azer_default_folder"
    private var currentSearch: String = ""

    fun getBookmarks(): List<Bookmark> {
        var bookmarks = repository.getAll()

        bookmarks = bookmarks.filter {
            it.folderId == currentFolderId
        }

        if (currentSearch.isNotBlank()) {
            bookmarks = BookmarkSearch.search(
                bookmarks,
                currentSearch
            )
        }

        return bookmarks
    }

    fun setFolder(folderId: String) {
        currentFolderId = folderId
    }

    fun search(query: String) {
        currentSearch = query
    }

    fun clearSearch() {
        currentSearch = ""
    }

    fun addBookmark(bookmark: Bookmark): Boolean {
        return repository.add(bookmark)
    }

    fun updateBookmark(bookmark: Bookmark) {
        repository.update(bookmark)
    }

    fun deleteBookmark(bookmark: Bookmark) {
        repository.delete(bookmark.id)
    }

    fun showBookmarkMenu(
        bookmark: Bookmark,
        anchor: View
    ) {
        BookmarkMenuHelper.show(
            context,
            anchor,
            bookmark,
            onOpen = {
                // Bookmark açma işlemi dışarıdan yönetilir.
            },
            onEdit = {
                editBookmark(bookmark)
            },
            onDelete = {
                confirmDelete(bookmark)
            }
        )
    }

    private fun editBookmark(bookmark: Bookmark) {
        BookmarkDialogHelper.showBookmarkDialog(
            context,
            bookmark
        ) { updated ->
            updateBookmark(updated)
        }
    }

    private fun confirmDelete(bookmark: Bookmark) {
        AlertDialog.Builder(context)
            .setTitle("Yer işaretini sil")
            .setMessage("${bookmark.title} silinsin mi?")
            .setPositiveButton("Sil") { _, _ ->
                deleteBookmark(bookmark)
            }
            .setNegativeButton("İptal", null)
            .show()
    }
}
