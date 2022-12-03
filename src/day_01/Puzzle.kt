package day_01

import readInput
import readTestInput

/** [Puzzle](https://adventofcode.com/2022/day/1) */
private const val DAY = "01"

fun main() {
    fun part1(input: List<String>): Int =
        getCalCountByElf(input).max()

    fun part2(input: List<String>): Int =
        getCalCountByElf(input)
            .sortedDescending()
            .take(3)
            .sum()

    // Test
    val testInput = readTestInput(DAY)
    check(part1(testInput) == 24000) { "Part 1 failed!" }
    check(part2(testInput) == 45000) { "Part 2 failed!" }

    // Result
    val input = readInput(DAY)
    println(part1(input))
    println(part2(input))
}

private fun getCalCountByElf(
    items: List<String>
): List<Int> = buildList {
    var sum = 0
    items.forEach { item ->
        if (item.isBlank()) {
            add(sum)
            sum = 0
        } else {
            sum += item.toInt()
        }
    }
    add(sum)
}
