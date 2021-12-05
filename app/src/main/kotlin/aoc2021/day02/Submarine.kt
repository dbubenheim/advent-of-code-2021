package aoc2021.day02

interface Submarine {
    fun drive(command: Command): Submarine
    fun result(): Int
}