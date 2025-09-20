package dev.pinta.sftpbrowser

import android.os.Build

class AndroidConnection : Connection {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getConnection(): Connection = AndroidConnection()