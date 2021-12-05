package aoc2021.day03

import aoc2021.day03.ReportType.EPSILON

data class EpsilonRate(val bits: List<Bit> = emptyList()) : Rate {
    override fun update(number: IntArray) = copy(bits = bits.update(number))
    override fun toDecimal() =
        bits.map { it.result(EPSILON) }
            .joinToString("")
            .toInt(2)
}