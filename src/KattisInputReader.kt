import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class KattisInputReader(stdin: InputStream) {
    private val bufferedReader: BufferedReader = BufferedReader(InputStreamReader(stdin))

    // String helper functions
    fun readLine(): String {
        return bufferedReader.readLine()
    }

    // Int helper functions
    fun readInt(radix: Int = 10): Int {
        return readLine().toInt(radix)
    }
    fun readListOfInts(radix: Int = 10): List<Int> {
        return readLine()
                .trim('\n')
                .split(' ')
                .map { it.toInt(radix) }
    }
    fun readSetOfInts(radix: Int = 10): Set<Int> {
        return readListOfInts(radix).toSet()
    }
    fun readPairOfInts(): Pair<Int, Int> {
        val line = readListOfInts()
        return Pair(line[0], line[1])
    }

    // Double helper functions
    fun readDouble(): Double {
        return readLine().toDouble()
    }
    fun readListOfDoubles(): List<Double> {
        return readLine()
                .trim('\n')
                .split(' ')
                .map { it.toDouble() }
    }
    fun readSetOfDoubles(): Set<Double> {
        return readListOfDoubles().toSet()
    }
    fun readPairOfDoubles(): Pair<Double, Double> {
        val line = readListOfDoubles()
        return Pair(line[0], line[1])
    }
}