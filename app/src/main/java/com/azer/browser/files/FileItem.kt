
package com.azer.browser.files

data class FileItem(
    val name: String,
    val path: String,
    val size: Long,
    val isDirectory: Boolean
)
