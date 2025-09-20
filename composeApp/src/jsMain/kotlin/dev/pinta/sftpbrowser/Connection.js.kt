package dev.pinta.sftpbrowser

class JsConnection : Connection {
    override val name: String = "Web with Kotlin/JS"
}

actual fun getConnection(): Connection = JsConnection()