package aoc2021.day10

class NavigationSubsystem(l: List<String>) {
    private val lines: List<NavigationLine> = l.map { it.toNavigationLine() }

    override fun toString(): String {
        return this.lines.toString()
    }

    fun syntaxErrorScore() = lines
        .filter { it.syntaxCheck.isCorrupt }
        .also { println("corrupt: ${it.size}") }
        .sumOf { it.syntaxCheck.errorScore }

    fun middleScore(): Long {
        val sortedBy = lines
            .filter { !it.syntaxCheck.isCorrupt }
            .also { println("incomplete: ${it.size}") }
            .sortedBy { it.syntaxCheck.middleScore }
            .also { println(it) }
        return sortedBy[sortedBy.size / 2].syntaxCheck.middleScore
    }
}

private fun String.toNavigationLine() = NavigationLine(this)
