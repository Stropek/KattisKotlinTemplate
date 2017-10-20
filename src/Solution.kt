package kattis.solution

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.io.PrintStream

fun main(args: Array<String>) {
    solve()
}

fun solve(stdin: InputStream = System.`in`, stdout: PrintStream = System.out){
    val reader = BufferedReader(InputStreamReader(stdin))

    var line = reader.readLine()
    stdout.println(line)
}