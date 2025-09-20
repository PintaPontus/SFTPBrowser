package dev.pinta.sftpbrowser

class JVMConnection : Connection {
    override val name: String = getSSHHost()
}

actual fun getConnection(): Connection = JVMConnection()