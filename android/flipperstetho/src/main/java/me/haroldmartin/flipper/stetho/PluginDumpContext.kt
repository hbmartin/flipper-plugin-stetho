package me.haroldmartin.flipper.stetho

import com.facebook.stetho.dumpapp.DumperContext
import org.apache.commons.cli.BasicParser

internal object PluginDumpContext {
    operator fun invoke(
        sink: OutputSink,
        pluginName: String,
        args: List<String>
    ): DumperContext {
        val printStream = PluginPrintStream(pluginName = pluginName, sink = sink)
        return DumperContext(
            stdin = PluginInputStream(),
            stdout = printStream,
            stderr = printStream,
            parser = BasicParser(),
            argsAsList = args
        )
    }
}
