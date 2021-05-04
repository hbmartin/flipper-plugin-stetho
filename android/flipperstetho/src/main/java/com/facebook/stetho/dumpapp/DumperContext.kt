package com.facebook.stetho.dumpapp

import org.apache.commons.cli.CommandLineParser
import java.io.InputStream;
import java.io.PrintStream;

class DumperContext(
    val stdin: InputStream,
    val stdout: PrintStream,
    val stderr: PrintStream,
    val parser: CommandLineParser,
    val argsAsList: List<String>
) {
    constructor(
        existingContext: DumperContext,
        newRemainingArguments: List<String>
    ) : this(
        existingContext.stdin,
        existingContext.stdout,
        existingContext.stderr,
        existingContext.parser,
        newRemainingArguments
    )
}
