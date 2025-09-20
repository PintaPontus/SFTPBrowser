package dev.pinta.sftpbrowser

class Greeting {
    private val connection = getConnection()

    fun greet(): String {
        return "Hello, ${connection.name}!"
    }
}