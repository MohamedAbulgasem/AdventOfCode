package day_03

import readInput

/** [Puzzle](https://adventofcode.com/2022/day/3) */
private const val DAY = "03"

fun main() {
    fun part1(input: List<String>): Int = input
        .map {
            val comps = it.toList().chunked(it.length / 2)
            Pair(comps[0].toSet(), comps[1].toSet())
        }
        .sumOf { comps ->
            comps.first
                .intersect(comps.second)
                .first()
                .priority
        }

    fun part2(input: List<String>): Int = input
        .chunked(3) {
            Triple(it[0].toSet(), it[1].toSet(), it[2].toSet())
        }
        .sumOf { group ->
            group.first
                .intersect(group.second)
                .intersect(group.third)
                .first()
                .priority
        }

    // Test
    val testInput = readInput(DAY, testInput = true)
    check(part1(testInput) == 157) { "Part 1 failed!" }
    check(part2(testInput) == 70) { "Part 2 failed!" }

    // Result
    val input = readInput(DAY)
    println(part1(input))
    println(part2(input))
}

private val Char.priority: Int
    get() = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
        .indexOf(this)
