package aoc2021.day07

import aoc2021.toFile
import kotlin.math.absoluteValue

class Day07 {

    companion object {

        @JvmStatic
        fun part1(): Long {
            val numbers = "input-day07.txt".toFile()
                .readLines()
                .first()
                .split(",")
                .map { it.toInt() }
                .sorted()

            println(numbers)

            val max = numbers.maxOrNull() ?: 0
            val min = numbers.minOrNull() ?: 0

            return (min..max)
                .map { position ->
                    position to numbers.sumOf { number ->
                        (position - number).absoluteValue.toLong()
                    }
                }
                .map { it.second }
                .sorted()
                .minOf { it }
        }

        @JvmStatic
        fun part2(): Long {
            val numbers: List<Int> = "input-day07.txt".toFile()
                .readLines()
                .first()
                .split(",")
                .map { it.toInt() }
                .sorted()

            println(numbers)

            val max = numbers.maxOrNull() ?: 0
            val min = numbers.minOrNull() ?: 0

            return (min..max)
                .map { position ->
                    position to numbers.sumOf { number ->
                        (position - number).absoluteValue.fuel()
                    }
                }
                .map { it.second }
                .sorted()
                .minOf { it }
        }

        @JvmStatic
        fun main(args: Array<String>) {
            println(part1())
            println(part2())
        }
    }
}

private fun Int.fuel(): Long {
    if (this == 0) return 1
    var factorial: Long = 1
    (this downTo 2).forEach { i ->
        factorial += i
    }
    return factorial
}