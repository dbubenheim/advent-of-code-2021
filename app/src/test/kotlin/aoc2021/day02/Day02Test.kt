package aoc2021.day02

import aoc2021.day02.Day02.Companion.divePart1
import aoc2021.day02.Day02.Companion.divePart2
import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class Day02Test {

    @Test
    fun testDivePart1() = assertThat(divePart1()).isEqualTo(1882980)

    @Test
    fun testDivePart2() = assertThat(divePart2()).isEqualTo(1971232560)
}