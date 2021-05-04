package me.haroldmartin.flipper.stetho

import java.io.InputStream

internal class PluginInputStream: InputStream() {
    override fun read(): Int  = -1
}