package day_04

import readInput

/** [Puzzle](https://adventofcode.com/2022/day/4) */
private const val DAY = "04"

fun main() {
    fun part1(input: List<String>): Int = input
        .mapToRangePair()
        .count { pair ->
            pair.first contains pair.second ||
            pair.second contains pair.first
        }

    fun part2(input: List<String>): Int = input
        .mapToRangePair()
        .count { pair ->
            pair.first overlaps pair.second
        }

// Test
val testInput = readInput(DAY, testInput = true)
check(part1(testInput) == 2) { "Part 1 failed!" }
check(part2(testInput) == 4) { "Part 2 failed!" }

// Result
val input = readInput(DAY)
println(part1(input))
println(part2(input))
}

private fun List<String>.mapToRangePair() = map {
    val firstRange = it.split(",").first()
    val secondRange = it.split(",").last()
    Pair(Range(firstRange), Range(secondRange))
}

private data class Range(val start: Int, val end: Int) {

    constructor(
        range: String
    ) : this(
        start = range.split("-").first().toInt(),
        end = range.split("-").last().toInt()
    )

    infix fun contains(other: Range): Boolean {
        return start <= other.start && end >= other.end
    }

    infix fun overlaps(other: Range): Boolean {
        return !(end < other.start || start > other.end)
    }
}
