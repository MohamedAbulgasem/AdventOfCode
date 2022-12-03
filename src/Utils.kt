import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/** Reads lines from the input txt file. */
fun readInput(
    day: String,
    testInput: Boolean = false
): List<String> {
    val dir = "src/day_$day"
    val file = if (testInput) "Input_test.txt" else "Input.txt"
    return File(dir, file).readLines()
}

/** Converts string to md5 hash. */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5")
    .digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')
