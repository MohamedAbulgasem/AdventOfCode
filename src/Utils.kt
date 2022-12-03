import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/** Reads lines from the input txt file. */
fun readInput(day: String): List<String> =
    File("src/day_$day", "Input.txt").readLines()

/** Reads lines from the test input txt file. */
fun readTestInput(day: String): List<String> =
    File("src/day_$day", "Input_test.txt").readLines()

/** Converts string to md5 hash. */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5")
    .digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')
