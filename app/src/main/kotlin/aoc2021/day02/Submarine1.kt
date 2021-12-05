package aoc2021.day02

import aoc2021.day02.Direction.*

data class Submarine1(
    val horizontalPosition: Int = 0,
    val depth: Int = 0
) : Submarine {

    override fun drive(command: Command) = when (command.direction) {
        UP -> copy(depth = depth - command.unit)
        DOWN -> copy(depth = depth + command.unit)
        FORWARD -> copy(horizontalPosition = horizontalPosition + command.unit)
        else -> throw IllegalArgumentException("Unknown command")
    }

    override fun result() = horizontalPosition * depth
}