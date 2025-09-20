package dev.pinta.sftpbrowser

import org.apache.sshd.client.SshClient
import org.apache.sshd.client.keyverifier.AcceptAllServerKeyVerifier
import org.apache.sshd.sftp.client.SftpClient
import org.apache.sshd.sftp.client.SftpClientFactory
import java.util.stream.StreamSupport

actual fun getSSHHost(): String {
    val list = StringBuilder()

    SshClient.setUpDefaultClient().use { client ->
        client.start()
        client.setServerKeyVerifier(AcceptAllServerKeyVerifier.INSTANCE)

        client.connect(
            System.getenv("USERNAME"),
            System.getenv("REMOTE_HOST"),
            22
        ).verify(10000)
            .session.use { session ->
                session.addPasswordIdentity(System.getenv("PASSWORD"))
                session.auth().verify(10000)

                val factory = SftpClientFactory.instance()

                factory.createSftpClient(session).use { sftp ->
                    val entriesIterable: Iterable<SftpClient.DirEntry?> = sftp.readDir("/")
                    StreamSupport.stream<SftpClient.DirEntry?>(entriesIterable.spliterator(), false)
                        .sorted(Comparator.comparing(SftpClient.DirEntry::getFilename))
                        .forEach {
                            list.appendLine(it?.longFilename)
                        }
                }
            }
    }
    return list.toString()
}

actual fun downloadFile(remoteFile: String, destination: String) {
    TODO("Not yet implemented")
}