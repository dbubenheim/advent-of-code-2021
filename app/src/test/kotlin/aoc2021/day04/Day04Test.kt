package aoc2021.day04

import aoc2021.day04.Day04.Companion.giantSquidPart1
import aoc2021.day04.Day04.Companion.giantSquidPart2
import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class Day04Test {

    @Test
    fun testGiantSquidPart1() = assertThat(giantSquidPart1()).isEqualTo(35711)

    @Test
    fun testGiantSquidPart2() = assertThat(giantSquidPart2()).isEqualTo(5586)
}