package aoc2021.day05

data class HydrothermalVent(private val line: String) {

    val begin: Point
    val end: Point

    init {
        val split = line.split(" -> ")
        begin = split.first().toPoint()
        end = split.last().toPoint()
    }

    override fun toString() = "${javaClass.simpleName}(begin=$begin - end=$end)"

    fun points() = begin..end

    fun isDiagonal() = begin.x != end.x && begin.y != end.y
}

private fun String.toPoint(): Point {
    val split = this.split(",")
    return Point(split.first().toInt(), split.last().toInt())
}
