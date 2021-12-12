package aoc2021.day05

data class HydrothermalDiagram(val vents: List<HydrothermalVent>, val diagonals: Boolean = false) {

    private val minX = vents.flatMap { it.points() }.minOf { it.x }
    private val maxX = vents.flatMap { it.points() }.maxOf { it.x }
    private val minY = vents.flatMap { it.points() }.minOf { it.y }
    private val maxY = vents.flatMap { it.points() }.maxOf { it.y }
    private val topLeft = Point(minX, minY)
    private val bottomRight = Point(maxX, maxY)
    private val pointCounts = vents.filter { if (diagonals) true else !it.isDiagonal() }
//        .also { println(it) }
        .flatMap { it.points() }
        .groupingBy { it }
        .eachCount()
    private val diagramPoints =
        (minY..maxY).flatMap { curX ->
            (minX..maxX).map { curY ->
                val point = Point(curX, curY)
                when (val count = pointCounts[point]) {
                    null -> DiagramPoint(Point(curX, curY))
                    else -> DiagramPoint(Point(curX, curY), count)
                }
            }
        }

    fun countOverlappingPoints() = vents
        .filter { if (diagonals) true else !it.isDiagonal() }
        //.also { println(it) }
        .flatMap { it.points() }
        .groupBy { it }
        .map { it.value.size }
        .count { it > 1 }

    fun print() {

        println("points:\n$diagramPoints")
        println("vents:\n$vents")
        println()
        println("diagram:")
        diagramPoints.groupBy { it.point.y }.forEach { row ->
            row.value.forEach { diagramPoint ->
                val out = if (diagramPoint.coveredBy == 0) ".  " else ("${diagramPoint.coveredBy}  ")
                print(out)
            }
            println()
        }
        println()
    }

    override fun toString() =
        "${this.javaClass.simpleName}(topLeft=$topLeft, bottomRight=$bottomRight, vents=$vents"
}