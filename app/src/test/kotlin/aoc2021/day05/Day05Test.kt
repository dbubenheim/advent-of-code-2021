package aoc2021.day05

import aoc2021.day05.Day05.Companion.hydrothermalVenturePart1
import aoc2021.day05.Day05.Companion.hydrothermalVenturePart2
import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

internal class Day05Test {

    @Test
    fun testHydrothermalVenturePart1() =
        assertThat(hydrothermalVenturePart1()).isEqualTo(8622)

    @Test
    fun testHydrothermalVenturePart2() =
        assertThat(hydrothermalVenturePart2()).isEqualTo(22037)
}