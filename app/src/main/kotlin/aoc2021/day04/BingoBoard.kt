package aoc2021.day04

data class BingoBoard(val grid: BingoGrid) {

    fun update(number: Int) {
        grid.fields.update(number)
    }

    fun bingo(): Boolean {
        grid.fields.forEach { row ->
            if (row.all { field -> field.checked }) return true
        }
        grid.fields.first().indices.forEach { index ->
            if (grid.fields.all { it[index].checked }) return true
        }
        return false
    }

    fun result(number: Int) =
        grid.fields.flatten().filter { !it.checked }.map { it.value }.sum() * number
}