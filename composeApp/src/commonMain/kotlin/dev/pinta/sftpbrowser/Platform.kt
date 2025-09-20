package dev.pinta.sftpbrowser

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform