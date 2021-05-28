package com.facebook.stetho

import android.content.Context
import com.facebook.stetho.dumpapp.DumperPlugin

class Stetho {
    @Suppress("UnusedPrivateMember")
    class DefaultDumperPluginsBuilder(context: Context) {
        private val pluginsList = mutableListOf<DumperPlugin>()

        fun provide(plugin: DumperPlugin): DefaultDumperPluginsBuilder {
            pluginsList.add(plugin)
            return this
        }

        fun provideIfDesired(plugin: DumperPlugin): DefaultDumperPluginsBuilder {
            return provide(plugin)
        }

        fun remove(plugin: DumperPlugin): DefaultDumperPluginsBuilder {
            pluginsList.remove(plugin)
            return this
        }

        fun finish(): Iterable<DumperPlugin> {
            return pluginsList
        }
    }
}
