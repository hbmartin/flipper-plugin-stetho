package com.facebook.stetho.dumpapp

import java.util.ArrayList

object ArgsHelper {
    fun nextOptionalArg(argsIter: Iterator<String>, defaultValue: String): String {
        return if (argsIter.hasNext()) argsIter.next() else defaultValue
    }

    @Throws(DumpUsageException::class)
    fun nextArg(argsIter: Iterator<String>, errorIfMissing: String?): String {
        if (!argsIter.hasNext()) {
            throw DumpUsageException(errorIfMissing)
        }
        return argsIter.next()
    }

    fun drainToArray(argsIter: Iterator<String>): Array<String> {
        val args: MutableList<String> = ArrayList()
        while (argsIter.hasNext()) {
            args.add(argsIter.next())
        }
        return args.toTypedArray()
    }
}
