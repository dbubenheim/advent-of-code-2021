package aoc2021

import aoc2021.day06.Day06
import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class Day06Test {

    @Test
    fun testLanternfishPart1() = assertThat(Day06.lanternfishPart1()).isEqualTo(5934)
}