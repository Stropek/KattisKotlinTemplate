import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class KattisInputReader(stdin: InputStream) {
    private val bufferedReader: BufferedReader = BufferedReader(InputStreamReader(stdin))

    fun readLineNullable(): String? {
        return bufferedReader.readLine()
    }

    // String helper functions
    fun readLine(): String {
        return bufferedReader.readLine()
    }
    fun readListOfStrings(): List<String> {
        return readLine()
                .trim('\n')
                .split(' ')
    }
    fun readSetOfStrings(): Set<String> {
        return readListOfStrings().toSet()
    }
    fun readPairOfStrings(): Pair<String, String> {
        val line = readListOfStrings()
        return Pair(line[0], line[1])
    }

    // Int helper functions
    fun readInt(radix: Int = 10): Int? {
        return readLineNullable()?.toInt(radix)
    }
    fun readListOfInts(radix: Int = 10): List<Int>? {
        return readLineNullable()
                ?.trim('\n')
                ?.split(' ')
                ?.map { it.toInt(radix) }
    }
    fun readSetOfInts(radix: Int = 10): Set<Int>? {
        return readListOfInts(radix)?.toSet()
    }
    fun readPairOfInts(): Pair<Int, Int>? {
        val line = readListOfInts()
        return if (line != null) Pair(line[0], line[1]) else null
    }

    // Long helper functions
    fun readLong(radix: Int = 10): Long? {
        return readLineNullable()?.toLong(radix)
    }
    fun readListOfLongs(radix: Int = 10): List<Long>? {
        return readLineNullable()
                ?.trim('\n')
                ?.split(' ')
                ?.map { it.toLong(radix) }
    }
    fun readSetOfLongs(radix: Int = 10): Set<Long>? {
        return readListOfLongs(radix)?.toSet()
    }
    fun readPairOfLongs(): Pair<Long, Long>? {
        val line = readListOfLongs()
        return if (line != null) Pair(line[0], line[1]) else null
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