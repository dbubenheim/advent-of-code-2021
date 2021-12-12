package aoc2021.day05

import aoc2021.toFile

class Day05 {

    companion object {

        @JvmStatic
        fun hydrothermalVenturePart1() = "input-day05.txt".toFile()
            .readLines()
            .toHydrothermalDiagram(diagonals = false)
            //.also { it.print() }
            .countOverlappingPoints()

        @JvmStatic
        fun hydrothermalVenturePart2() = "input-day05.txt".toFile()
            .readLines()
            .toHydrothermalDiagram(diagonals = true)
            //.also { it.print() }
            .countOverlappingPoints()

        @JvmStatic
        fun main(args: Array<String>) {
            println(hydrothermalVenturePart1())
            println(hydrothermalVenturePart2())
        }
    }
}

private fun List<String>.toHydrothermalDiagram(diagonals: Boolean = false) =
    HydrothermalDiagram(this.map { it.toHydrothermalVent() }, diagonals)

private fun String.toHydrothermalVent() = HydrothermalVent(this)
