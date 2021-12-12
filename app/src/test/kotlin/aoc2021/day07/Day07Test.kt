package aoc2021.day07

import aoc2021.day07.Day07.Companion.treacheryOfWhalesPart1
import aoc2021.day07.Day07.Companion.treacheryOfWhalesPart2
import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

internal class Day07Test {

    @Test
    fun testTreacheryOfWhalesPart1() =
        assertThat(treacheryOfWhalesPart1()).isEqualTo(342641)

    @Test
    fun testTreacheryOfWhalesPart2() =
        assertThat(treacheryOfWhalesPart2()).isEqualTo(93006301)
}