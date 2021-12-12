package aoc2021.day10

import aoc2021.day10.Day10.Companion.syntaxScoringPart1
import aoc2021.day10.Day10.Companion.syntaxScoringPart2
import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class Day10Test {

    @Test
    fun testSyntaxScoringPart1() =
        assertThat(syntaxScoringPart1()).isEqualTo(392139)

    @Test
    fun testSyntaxScoringPart2() =
        assertThat(syntaxScoringPart2()).isEqualTo(4001832844)
}