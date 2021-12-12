package aoc2021.day03

import aoc2021.toFile

class Day03 {

    companion object {

        @JvmStatic
        fun binaryDiagnosticPart1(): Int {
            return "input-day03.txt"
                .toFile()
                .readLines()
                .map { it.toIntArray() }
                .fold(DiagnosticReport()) { report, number -> report.update(number) }
                .result()
        }

        @JvmStatic
        fun binaryDiagnosticPart2(): Int {
            val numbers = "input-day03.txt"
                .toFile()
                .readLines()
                .map { it.toIntArray() }
                .toList()

            val indices = numbers.first().indices

            val mostCommonValue = findMostCommonValue(indices, numbers)
            val leastCommonValue = findLeastCommonValue(indices, numbers)

            val oxygenGeneratorRatingBinary = findOxygenGeneratorRating(numbers, indices, mostCommonValue)
            val oxygenGeneratorRating = oxygenGeneratorRatingBinary.toDecimal()

            val co2ScrubberRatingBinary = findCo2ScrubberRating(indices, numbers, leastCommonValue)
            val co2ScrubberRating = co2ScrubberRatingBinary.toDecimal()

            return oxygenGeneratorRating * co2ScrubberRating
        }

        private fun findCo2ScrubberRating(
            indices: IntRange,
            numbers: List<IntArray>,
            leastCommonValue: String
        ): IntArray {
            var n = numbers
            indices.takeWhile { i ->
                n = n.filter { it[i] == leastCommonValue[i].digitToInt() }
                n.size != 1
            }
            return n.first()
        }

        private fun findOxygenGeneratorRating(
            numbers: List<IntArray>,
            indices: IntRange,
            mostCommonValue: String
        ): IntArray {
            var n = numbers
            indices.takeWhile { i ->
                n = n.filter { it[i] == mostCommonValue[i].digitToInt() }
                n.size != 1
            }
            return n.first()
        }

        private fun findLeastCommonValue(
            indices: IntRange,
            input: List<IntArray>
        ): String {
            var numbers = input
            val leastCommonValue = indices.joinToString(separator = "") { index ->
                val count0 = numbers.count { it[index] == 0 }
                val count1 = numbers.count { it[index] == 1 }
                numbers = numbers.filter { it[index] == if (count1 < count0) 1 else 0 }
                if (count1 < count0) "1" else "0"
            }
            return leastCommonValue
        }

        private fun findMostCommonValue(
            indices: IntRange,
            input: List<IntArray>
        ): String {
            var numbers = input
            val mostCommonValue = indices.joinToString(separator = "") { index ->
                val count0 = numbers.count { it[index] == 0 }
                val count1 = numbers.count { it[index] == 1 }
                numbers = numbers.filter { it[index] == if (count0 > count1) 0 else 1 }
                if (count0 > count1) "0" else "1"
            }
            return mostCommonValue
        }

        @JvmStatic
        fun main(args: Array<String>) {
            println(binaryDiagnosticPart1())
            println(binaryDiagnosticPart2())
        }
    }
}

private fun String.toIntArray(): IntArray = chars().map { Character.getNumericValue(it) }.toArray()

private fun IntArray.toDecimal() = joinToString("").toInt(2)
