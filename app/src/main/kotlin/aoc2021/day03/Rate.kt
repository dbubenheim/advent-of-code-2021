package aoc2021.day03

interface Rate {
    fun update(number: IntArray): Rate
    fun toDecimal(): Int
}