package aoc2021.day04

data class BingoField(val value: Int, var checked : Boolean = false) {
    override fun toString() = "[$value/${if(checked) "y" else "n"}]"
}
