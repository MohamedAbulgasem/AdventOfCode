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

    val dayId = "03"
    // Test
    val testInput = readInput("Day${dayId}_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    // Result
    val input = readInput("Day${dayId}")
    println(part1(input))
    println(part2(input))
}

private val Char.priority: Int
    get() = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
        .indexOf(this)
