package kattis.solution

import java.io.InputStream
import java.io.PrintStream
import KattisInputReader

fun main(args: Array<String>) {
    solve()
}

fun solve(stdin: InputStream = System.`in`, stdout: PrintStream = System.out){
    val reader = KattisInputReader(stdin)

    var line = reader.readLine()
    stdout.print("$line\n")
}