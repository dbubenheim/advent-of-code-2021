package aoc2021.day03

import aoc2021.day03.ReportType.EPSILON
import aoc2021.day03.ReportType.GAMMA

data class Bit(val index: Int = 0, val zeros: Int = 0, val ones: Int = 0) {

    fun result(reportType: ReportType) = when (reportType) {
        GAMMA -> if (zeros > ones) 0 else 1
        EPSILON -> if (zeros < ones) 0 else 1
    }

    fun update(number: Int) = when (number) {
        0 -> copy(zeros = zeros + 1)
        1 -> copy(ones = ones + 1)
        else -> throw IllegalArgumentException("Unknown number")
    }
}

fun List<Bit>.update(number: IntArray) = if (isEmpty()) number.toBit() else
    number.mapIndexed { index, i -> this[index].update(i) }

private fun IntArray.toBit() = this.mapIndexed { index, number ->
    if (number == 0) Bit(index = index, zeros = 1) else Bit(index = index, ones = 1)
}
