package day_02

import readInput
import readTestInput

/** [Puzzle](https://adventofcode.com/2022/day/2) */
private const val DAY = "02"

fun main() {
    fun part1(input: List<String>): Int = input.sumOf {
        getRoundScore(
            opponentPlay = it[0].mapToScoreValue(),
            myPlay = it[2].mapToScoreValue()
        )
    }

    fun part2(input: List<String>): Int = input.sumOf {
        getRoundScore(
            opponentPlay = it[0].mapToScoreValue(),
            myPlay = workOutMyPlay(it[0], it[2])
        )
    }

    // Test
    val testInput = readTestInput(DAY)
    check(part1(testInput) == 15) { "Part 1 failed!" }
    check(part2(testInput) == 12) { "Part 2 failed!" }

    // Result
    val input = readInput(DAY)
    println(part1(input))
    println(part2(input))
}

private fun getRoundScore(opponentPlay: Int, myPlay: Int): Int {
    var roundScore = myPlay
    roundScore += when {
        // Draw
        myPlay == opponentPlay -> 3

        // Win
        myPlay == 1 && opponentPlay == 3 ||
        myPlay == 2 && opponentPlay == 1 ||
        myPlay == 3 && opponentPlay == 2 -> 6

        // Loss
        else -> 0
    }
    return roundScore
}

private fun Char.mapToScoreValue(): Int = when (this) {
    'A', 'X' -> 1
    'B', 'Y' -> 2
    else -> 3
}

private fun workOutMyPlay(
    opponentPlay: Char,
    expectedResult: Char
): Int = when (expectedResult) {
    'X' -> when (opponentPlay) {
        'A' -> 3
        'B' -> 1
        else -> 2
    }
    'Y' -> when (opponentPlay) {
        'A' -> 1
        'B' -> 2
        else -> 3
    }
    else -> when (opponentPlay) {
        'A' -> 2
        'B' -> 3
        else -> 1
    }
}
