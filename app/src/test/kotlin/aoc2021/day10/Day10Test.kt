package aoc2021.day10

import aoc2021.day10.Day10.Companion.part1
import aoc2021.day10.Day10.Companion.part2
import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class Day10Test {

    @Test
    fun testPart1() =
        assertThat(part1()).isEqualTo(392139)

    @Test
    fun testPart2() =
        assertThat(part2()).isEqualTo(4001832844)
}