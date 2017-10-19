package tests

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.Arguments

import kattis.solution.*
import org.omg.CORBA.TCKind
import java.io.*
import java.nio.charset.Charset
import java.util.stream.Stream

class KotlinJunitTest {

    @ParameterizedTest
    @MethodSource("getTestCases")
    fun fileInput(testCase: TestCase) {

        var inFile = "$testFilesDir/${testCase.inFile}"
        var outFile = "$testFilesDir/${testCase.outFile}"

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

    companion object {
        val testFilesDir = "TestFiles"

        @JvmStatic fun getTestCases(): Stream<TestCase> {
            var testCases: ArrayList<TestCase> = arrayListOf()

            File(testFilesDir).walk()
                    .filter { it.name.endsWith(".in") }
                    .forEach { testCases.add(TestCase(it.name, it.name.replace(".in", ".ans"))) }

            return testCases.stream()
        }
    }
}
