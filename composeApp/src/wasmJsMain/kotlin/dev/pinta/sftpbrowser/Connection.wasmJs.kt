package dev.pinta.sftpbrowser

class WasmConnection : Connection {
    override val name: String = "Web with Kotlin/Wasm"
}

actual fun getConnection(): Connection = WasmConnection()