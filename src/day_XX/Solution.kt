package day_XX

import readInput

/** [Puzzle](https://adventofcode.com/2022/day/XX) */
private const val DAY = "XX"

fun main() {
    fun part1(input: List<String>): Int {

        return 0
    }

    fun part2(input: List<String>): Int {

        return 0
    }

    // Test
    val testInput = readInput(DAY, testInput = true)
    check(part1(testInput) == 0) { "Part 1 failed!" }
    check(part2(testInput) == 0) { "Part 2 failed!" }

    // Result
    val input = readInput(DAY)
    println(part1(input))
    println(part2(input))
}
