package com.facebook.stetho.dumpapp

interface DumperPlugin {
    fun getName(): String
    fun dump(dumpContext: DumperContext)
}
