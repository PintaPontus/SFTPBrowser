package dev.pinta.sftpbrowser

expect fun getSSHHost(): String

expect fun downloadFile(remoteFile: String, destination: String)