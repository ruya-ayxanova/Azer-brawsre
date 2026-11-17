
package com.azer.browser.files

object FileSizeFormatter {

    fun format(size: Long): String {
        if (size < 1024) return "$size B"

        val kb = size / 1024.0
        if (kb < 1024) return "%.2f KB".format(kb)

        val mb = kb / 1024.0
        if (mb < 1024) return "%.2f MB".format(mb)

        val gb = mb / 1024.0
        return "%.2f GB".format(gb)
    }
}
