package day_06

import readInput

/** [Puzzle](https://adventofcode.com/2022/day/6) */
private const val DAY = "06"

fun main() {
    fun part1(input: List<String>): Int =
        input.findMarkerPosition(numOfChars = 4)

    fun part2(input: List<String>): Int =
        input.findMarkerPosition(numOfChars = 14)

    // Test
    val testInput = readInput(DAY, testInput = true)
    check(part1(testInput) == 5) { "Part 1 failed!" }
    check(part2(testInput) == 23) { "Part 2 failed!" }

    // Result
    val input = readInput(DAY)
    println(part1(input))
    println(part2(input))
}

private fun List<String>.findMarkerPosition(numOfChars: Int): Int {
    val chars = first().toCharArray()
    var markerPosition = 0
    for (i in chars.indices) {
        val position = i + numOfChars
        if (position > chars.lastIndex) break
        val charGroup = chars.sliceArray(i until position).toSet()
        if (charGroup.size == numOfChars) {
            markerPosition = position
            break
        }
    }
    return markerPosition
}
