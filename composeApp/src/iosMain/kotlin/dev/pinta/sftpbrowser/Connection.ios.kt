package dev.pinta.sftpbrowser

import platform.UIKit.UIDevice

class IOSConnection : Connection {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getConnection(): Connection = IOSConnection()