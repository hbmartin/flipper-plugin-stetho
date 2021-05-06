package me.haroldmartin.flipperstethodemo

import com.facebook.stetho.dumpapp.DumperContext
import com.facebook.stetho.dumpapp.DumperPlugin

class MyDumperPlugin : DumperPlugin {
    override fun dump(dumpContext: DumperContext) {
        val args = dumpContext.argsAsList
        if (args.isNotEmpty()) {
            dumpContext.stdout.println(args[0])
        }
        dumpContext.stdout.println("another line")
    }

    override fun getName(): String = "hello"
}
