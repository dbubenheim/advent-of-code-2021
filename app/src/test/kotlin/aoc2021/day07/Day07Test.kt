package aoc2021.day07

import aoc2021.day07.Day07.Companion.part1
import aoc2021.day07.Day07.Companion.part2
import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

internal class Day07Test {

    @Test
    fun testPart1() =
        assertThat(part1()).isEqualTo(342641)

    @Test
    fun testPart2() =
        assertThat(part2()).isEqualTo(93006301)
}