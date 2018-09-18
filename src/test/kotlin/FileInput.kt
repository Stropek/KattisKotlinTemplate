import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import tests.TestCase

import java.io.*
import java.nio.charset.Charset
import java.util.stream.Stream

class KotlinJunitTest {
    companion object {

        @JvmStatic
        fun getTestCases(): Stream<TestCase> {
            val testDataDirectory = "{TEST_DATA_DIRECTORY}"
            val testCases: ArrayList<TestCase> = arrayListOf()

            File(testDataDirectory).walk()
                    .filter { it.absolutePath.endsWith(".in") }
                    .forEach { testCases.add(TestCase(it.absolutePath, it.absolutePath.replace(".in", ".ans"))) }

            return testCases.stream()
        }
    }

    @ParameterizedTest
    @MethodSource("getTestCases")
    fun fileInput(testCase: TestCase) {

        val expected = File(testCase.outFile).readText()

        File(testCase.inFile).inputStream().use { inStream ->
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
