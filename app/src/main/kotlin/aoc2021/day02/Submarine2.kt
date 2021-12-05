package aoc2021.day02

import aoc2021.day02.Direction.*

data class Submarine2(
    val horizontalPosition: Int = 0,
    val depth: Int = 0,
    val aim: Int = 0
) : Submarine {

    override fun drive(command: Command) =
        when (command.direction) {
            UP -> copy(aim = aim - command.unit)
            DOWN -> copy(aim = aim + command.unit)
            FORWARD -> copy(horizontalPosition = horizontalPosition + command.unit, depth = depth + aim * command.unit)
            else -> error("Invalid command")
        }

    override fun result() = horizontalPosition * depth
}