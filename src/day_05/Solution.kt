package day_05

import readInput
import java.util.Stack

/** [Puzzle](https://adventofcode.com/2022/day/5) */
private const val DAY = "05"

fun main() {
    fun part1(input: List<String>): String = input
        .mapToStacks()
        .moveCrates(
            input = input,
            multipleAtOnce = false
        )
        .combineTopCrates()

    fun part2(input: List<String>): String = input
        .mapToStacks()
        .moveCrates(
            input = input,
            multipleAtOnce = true
        )
        .combineTopCrates()

    // Test
    val testInput = readInput(DAY, testInput = true)
    check(part1(testInput) == "CMZ") { "Part 1 failed!" }
    check(part2(testInput) == "MCD") { "Part 2 failed!" }

    // Result
    val input = readInput(DAY)
    println(part1(input))
    println(part2(input))
}

private fun List<String>.mapToStacks(): Map<Int, Stack<Char>> {
    val stacks = HashMap<Int, Stack<Char>>()
    val cratesStartIndex = indexOf("") - 2
    for (i in cratesStartIndex downTo 0) {
        var stackNum = 1
        var charPos = 1
        val row = get(i).toCharArray()
        while (row.size > charPos) {
            if (row[charPos].isLetter()) {
                if (stacks[stackNum] == null) stacks[stackNum] = Stack()
                stacks[stackNum]?.add(row[charPos])
            }
            stackNum++
            charPos += 4
        }
    }
    return stacks
}

private fun Map<Int, Stack<Char>>.moveCrates(
    input: List<String>,
    multipleAtOnce: Boolean
): Collection<Stack<Char>> {
    val instructsStartIndex = input.indexOf("") + 1
    for (i in instructsStartIndex until input.size) {
        val nums = input[i].filter { it.isDigit() }
        val numOfCrates = nums.take(nums.lastIndex - 1).toInt()
        val fromStack = get("${nums[nums.lastIndex - 1]}".toInt())
        val toStack = get("${nums[nums.lastIndex]}".toInt())

        val creates = mutableListOf<Char>()
        repeat(numOfCrates) {
            fromStack?.pop()?.let(creates::add)
        }
        if (multipleAtOnce) creates.reverse()
        toStack?.addAll(creates)
    }
    return values
}

private fun Collection<Stack<Char>>.combineTopCrates() =
    filter { it.isNotEmpty() }
        .map { it.pop() }
        .joinToString("")
