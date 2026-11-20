
package com.azer.browser

interface BookmarkCallbacks {

    fun onBookmarkOpened(bookmark: Bookmark)

    fun onBookmarkEditRequested(bookmark: Bookmark)

    fun onBookmarkDeleteRequested(bookmark: Bookmark)

    fun onBookmarkMoveRequested(bookmark: Bookmark)

    fun onFolderSelected(folder: BookmarkFolder)

    fun onAddBookmarkRequested()

    fun onAddFolderRequested()
}
