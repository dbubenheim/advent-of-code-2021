package aoc2021.day04

class BingoGrid(val fields: List<List<BingoField>>) {
    override fun toString() = fields.toString()
}

fun List<List<BingoField>>.update(number: Int) {
    this.forEach { row ->
        row.forEach { field ->
            if (field.value == number) {
                field.checked = true
            }
        }
    }
}
