package day_07

import readInput

/** [Puzzle](https://adventofcode.com/2022/day/7) */
private const val DAY = "07"

fun main() {
    fun part1(input: List<String>): Int = input
        .mapToDirs()
        .filter { it.size <= 100000 }
        .sumOf { it.size }

    fun part2(input: List<String>): Int = input
        .mapToDirs()
        .run {
            val totalSize = first().size
            filter {
                val sizeAfter = totalSize - it.size
                70000000 - sizeAfter >= 30000000
            }
        }
        .minOf { it.size }

    // Test
    val testInput = readInput(DAY, testInput = true)
    check(part1(testInput) == 95437) { "Part 1 failed!" }
    check(part2(testInput) == 24933642) { "Part 2 failed!" }

    // Result
    val input = readInput(DAY)
    println(part1(input))
    println(part2(input))
}

private data class Dir(
    val name: String,
    val parent: Dir? = null,
    val dirs: MutableList<Dir> = ArrayList(),
    val files: MutableList<File> = ArrayList()
) {
    val size: Int
        get() = dirs.sumOf { it.size } + files.sumOf { it.size }

    fun listAllDirs(): List<Dir> = buildList {
        add(this@Dir)
        dirs.forEach { dir ->
            addAll(dir.listAllDirs())
        }
    }
}

private data class File(val size: Int)

private fun List<String>.mapToDirs(): List<Dir> {
    val root = Dir(name = "/", parent = null)
    var currentDir = root
    for (line in this) {
        when {
            line.startsWith("$ cd") -> {
                val arg = line.substringAfter("$ cd ")
                currentDir = if (arg == "..") {
                    currentDir.parent
                } else {
                    currentDir.dirs.find { it.name == arg }
                } ?: continue
            }

            line.startsWith("dir") -> {
                val dirName = line.substringAfter("dir ")
                currentDir.dirs.add(Dir(name = dirName, parent = currentDir))
            }

            line.split(" ").first().all { it.isDigit() } -> {
                val size = line.split(" ").first().toInt()
                currentDir.files.add(File(size = size))
            }
        }
    }
    return root.listAllDirs()
}
