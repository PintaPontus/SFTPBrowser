package dev.pinta.sftpbrowser

interface Connection {
    val name: String
}

expect fun getConnection(): Connection