package me.haroldmartin.flipper.stetho

import java.io.ByteArrayOutputStream
import java.io.PrintStream

internal class PluginPrintStream(
    pluginName: String,
    sink: OutputSink
) : PrintStream(
    PluginOutputStream(pluginName = pluginName, sink = sink),
    true
)

private class PluginOutputStream(
    private val pluginName: String,
    private val sink: OutputSink
) : ByteArrayOutputStream() {
    override fun flush() {
        val bufferedString = toString()
        reset()
        sink.appendOutput(pluginName, bufferedString)
    }
}
