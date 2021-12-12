package aoc2021.day10

import aoc2021.toFile

class Day10 {

    companion object {

        @JvmStatic
        fun syntaxScoringPart1(): Int {
            return "input-day10.txt".toFile()
                .readLines()
                .toNavigationSubsystem()
                .syntaxErrorScore()
        }

        @JvmStatic
        fun syntaxScoringPart2(): Long {
            return "input-day10.txt".toFile()
                .readLines()
                .toNavigationSubsystem()
                .middleScore()
        }

        @JvmStatic
        fun main(args: Array<String>) {
            println(syntaxScoringPart1())
            println(syntaxScoringPart2())
        }
    }
}

private fun List<String>.toNavigationSubsystem() = NavigationSubsystem(this)
    .also { println(it) }