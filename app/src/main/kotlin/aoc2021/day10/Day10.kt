package aoc2021.day10

import aoc2021.toFile

class Day10 {

    companion object {

        @JvmStatic
        fun part1(): Int {
            return "input-day10.txt".toFile()
                .readLines()
                .toNavigationSubsystem()
                .syntaxErrorScore()
        }

        @JvmStatic
        fun part2(): Long {
            return "input-day10.txt".toFile()
                .readLines()
                .toNavigationSubsystem()
                .middleScore()
        }

        @JvmStatic
        fun main(args: Array<String>) {
            println(part1())
            println(part2())
        }
    }
}

private fun List<String>.toNavigationSubsystem() = NavigationSubsystem(this)
    .also { println(it) }