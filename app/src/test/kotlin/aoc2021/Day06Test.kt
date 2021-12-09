package aoc2021

import aoc2021.day06.Day06.Companion.lanternfishPart1
import aoc2021.day06.Day06.Companion.lanternfishPart2
import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class Day06Test {

    @Test
    fun testLanternfishPart1() =
        assertThat(lanternfishPart1()).isEqualTo(353079)

    @Test
    fun testLanternfishPart2() =
        assertThat(lanternfishPart2()).isEqualTo(1605400130036)
}