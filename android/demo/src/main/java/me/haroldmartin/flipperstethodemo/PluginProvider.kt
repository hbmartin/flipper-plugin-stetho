package me.haroldmartin.flipperstethodemo

import me.haroldmartin.flipper.stetho.StethoFlipperPlugin

object PluginProvider {
    val stethoPlugin = StethoFlipperPlugin(listOf(MyDumperPlugin()))

    val all = listOf(stethoPlugin)
}
