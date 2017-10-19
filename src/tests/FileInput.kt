package tests

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import kattis.solution.*
import java.io.*
import java.nio.charset.Charset

class KotlinJunitTest {
    @Test
    fun fileInput() {

        var inFile = "TestFiles/test.in"
        var outFile = "TestFiles/test.out"

        val expected = File(outFile).readText()

        File(inFile).inputStream().use { inStream ->
            ByteArrayOutputStream().use { outStream ->
                PrintStream(outStream).use { printStream ->
                    solve(inStream, printStream)

                    val result = outStream.toByteArray().toString(Charset.defaultCharset())
                    Assertions.assertEquals(expected, result)
                }
            }
        }
    }
}
