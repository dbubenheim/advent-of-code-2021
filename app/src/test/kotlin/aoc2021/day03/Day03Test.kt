package aoc2021.day03

import aoc2021.day03.Day03.Companion.binaryDiagnosticPart1
import aoc2021.day03.Day03.Companion.binaryDiagnosticPart2
import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class Day03Test {

    @Test
    fun testBinaryDiagnosticPart1() = assertThat(binaryDiagnosticPart1()).isEqualTo(4174964)

    @Test
    fun testBinaryDiagnosticPart2() = assertThat(binaryDiagnosticPart2()).isEqualTo(4474944)
}