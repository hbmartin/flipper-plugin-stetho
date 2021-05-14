package me.haroldmartin.flipper.stetho

import com.facebook.flipper.core.FlipperObject
import com.facebook.flipper.core.FlipperReceiver
import com.facebook.flipper.core.FlipperResponder
import com.facebook.stetho.dumpapp.DumperPlugin

internal class StethoFlipperReceiver(
    private val plugins: Iterable<DumperPlugin>,
    private val sink: OutputSink
) : FlipperReceiver {
    override fun onReceive(params: FlipperObject, responder: FlipperResponder) {
        val pluginName = params.get("command") as? String
        val pluginArgs = params.get("arguments") as? String
        if (pluginName == null) return
        val dumpContext = PluginDumpContext(
            sink = sink,
            pluginName = pluginName,
            args = pluginArgs?.split(" ") ?: listOf()
        )

        plugins.find { it.getName() == pluginName }?.dump(dumpContext) ?: run {
            responder.error(
                FlipperObject.Builder()
                    .put("error", "could not find stetho plugin $pluginName")
                    .build()
            )
        }
    }
}
