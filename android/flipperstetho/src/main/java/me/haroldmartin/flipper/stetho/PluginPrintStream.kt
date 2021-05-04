package me.haroldmartin.flipper.stetho

import android.util.Log
import com.facebook.flipper.core.FlipperObject
import com.facebook.flipper.core.FlipperResponder
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
        Log.e("POS", "flush: ${toString()}")

        val bufferedString = toString()
        reset()
        sink.appendOutput(pluginName, bufferedString)
    }

    override fun close() {
        super.close()
        Log.e("POS", "close")
    }
}