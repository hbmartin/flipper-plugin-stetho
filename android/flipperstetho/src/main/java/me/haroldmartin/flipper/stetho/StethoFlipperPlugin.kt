package me.haroldmartin.flipper.stetho

import com.facebook.flipper.core.FlipperArray
import com.facebook.flipper.core.FlipperConnection
import com.facebook.flipper.core.FlipperObject
import com.facebook.flipper.core.FlipperPlugin
import com.facebook.stetho.dumpapp.DumperPlugin

class StethoFlipperPlugin(private val plugins: Iterable<DumperPlugin>) : FlipperPlugin, OutputSink {
    private var connection: FlipperConnection? = null

    override fun getId() = "stetho"

    override fun onConnect(connection: FlipperConnection) {
        this.connection = connection
        connection.send("pluginList", plugins.map { it.getName() }.toFlipperArray())
        connection.receive("execute", StethoFlipperReceiver(plugins, this))
    }

    override fun appendOutput(pluginId: String, output: String) {
        connection?.send(
            "appendOutput",
            FlipperObject.Builder().put("id", pluginId).put("output", output).build()
        )
    }

    override fun onDisconnect() {
        connection = null
    }

    override fun runInBackground() = false
}

interface OutputSink {
    fun appendOutput(pluginId: String, output: String)
}

private fun Iterable<String>.toFlipperArray(): FlipperArray =
    fold(FlipperArray.Builder()) { builder, string -> builder.put(string) }.build()
