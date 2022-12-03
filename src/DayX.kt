/** [Puzzle]( https://adventofcode.com/2022/day/X ) */
private const val DAY = "X"

fun main() {
    fun part1(input: List<String>): Int {

        return input.size
    }

    fun part2(input: List<String>): Int {

        return input.size
    }

    // Test
    val testInput = readInput("Day${DAY}_test")
    check(part1(testInput) == 0)
    //check(part2(testInput) == 0)

    // Result
    val input = readInput("Day${DAY}")
    println(part1(input))
    //println(part2(input))
}
