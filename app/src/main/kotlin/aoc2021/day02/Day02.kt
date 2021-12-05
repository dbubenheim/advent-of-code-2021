package aoc2021.day02

import aoc2021.day02.Direction.*
import aoc2021.toFile

class Day02 {

    companion object {

        fun divePart1(): Int {
            val commands = "input-day02.txt".toFile().readLines().map { it.toCommand() }
            return commands
                .fold(Submarine1()) { submarine, command -> submarine.drive(command) }
                .result()
        }

        fun divePart1_2(): Int {
            val commands = "input-day02.txt".toFile().readLines().map { it.toCommand() }
            val positions = commands
                .groupBy { it.direction }
                .mapValues { it.value.sumOf { it.unit } }

            return (positions.getOrElse(DOWN) { 0 } - positions.getOrElse(UP) { 0 }) * positions.getOrElse(FORWARD) { 0 }
        }

        fun divePart2(): Int {
            val commands = "input-day02.txt".toFile().readLines().map { it.toCommand() }
            return commands
                .fold(Submarine2()) { submarine, command -> submarine.drive(command) }
                .result()
        }

        @JvmStatic
        fun main(args: Array<String>) {
            println(divePart1())
            println(divePart2())
        }
    }
}

private fun String.toCommand(): Command {
    val parts = split(" ")
    return Command(direction = parts[0].toDirection(), unit = parts[1].toInt())
}

private fun String.toDirection() = Direction.from(this)