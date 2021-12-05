package aoc2021.day02

enum class Direction {
    UP,
    DOWN,
    FORWARD,
    BACKWARD;

    companion object {

        fun from(value: String) : Direction {
            return enumValues<Direction>().first { it.name == value.uppercase() }
        }
    }
}