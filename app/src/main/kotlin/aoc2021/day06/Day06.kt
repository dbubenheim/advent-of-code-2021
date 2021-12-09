package aoc2021.day06

import aoc2021.toFile

class Day06 {

    companion object {

        @JvmStatic
        fun lanternfishPart1() = "input-day06.txt".toFile()
            .readLines()
            .first()
            .split(",")
            .map { it.toInt() }
            .groupingBy { it }
            .eachCount()
            .map { it.key to it.value.toLong() }
            .toMap()
            .lanternfish()

        @JvmStatic
        fun lanternfishPart2() = "input-day06.txt".toFile()
            .readLines()
            .first()
            .split(",")
            .map { it.toInt() }
            .groupingBy { it }
            .eachCount()
            .map { it.key to it.value.toLong() }
            .toMap()
            .lanternfish(256)

        @JvmStatic
        fun main(args: Array<String>) {
            println(lanternfishPart1())
            println(lanternfishPart2())
        }
    }
}

private fun Map<Int, Long>.lanternfish(days: Int = 80): Long {
    println("initial state: ${this.toSortedMap()}")
    var numbers = this
    repeat(days) { day ->
        val timers = numbers.keys.sorted()
        val hasZeros = timers.contains(0)
        val currentNumbers = numbers.toMutableMap()
        val zeroCount = numbers[0] ?: 0
        timers.forEach { timer ->
            val count = currentNumbers[timer] ?: 0
            when (timer) {
                0 -> currentNumbers[0] = 0
                else -> {
                    currentNumbers[timer] = currentNumbers[timer]?.minus(count) ?: 0
                    currentNumbers[timer - 1] = currentNumbers[timer - 1]?.plus(count) ?: count
                }
            }
            println("timer[$timer]: ${currentNumbers.toSortedMap()}")
        }
        if (hasZeros) {
            currentNumbers[6] = currentNumbers[6]?.plus(zeroCount) ?: zeroCount
            currentNumbers[8] = currentNumbers[8]?.plus(zeroCount) ?: zeroCount
        }
        numbers = currentNumbers
        println("day[${day + 1}]: ${numbers.toSortedMap()}")
    }
    return numbers.values.sum()
}
