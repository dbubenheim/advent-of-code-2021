package aoc2021.day10

import kotlin.streams.asSequence

data class NavigationLine(val value: String) {
    val syntaxCheck: SyntaxCheck = value.checkSyntax()
    override fun toString(): String = "$value: $syntaxCheck"
}

private fun String.checkSyntax(): SyntaxCheck {

    val errorScores: Map<Char, Int> = mapOf(
        ')' to 3,
        ']' to 57,
        '}' to 1197,
        '>' to 25137,
    )
    val middleScores: Map<Char, Long> = mapOf(
        ')' to 1,
        ']' to 2,
        '}' to 3,
        '>' to 4,
    )
    val openers = listOf('(', '{', '[', '<')
    val closerToOpener = mapOf(
        ')' to '(',
        '}' to '{',
        ']' to '[',
        '>' to '<'
    )
    val openerToCloser = closerToOpener.entries.associate { (k, v) -> v to k }

    val openingStack = ArrayDeque<Char>()

    val errorScore = chars()
        .asSequence()
        .map { it.toChar() }
        .firstOrNull { character ->
            val isClosing = character !in openers
            if (!isClosing) openingStack.addFirst(character)
            isClosing && closerToOpener[character] != openingStack.removeFirst()
        }
        ?.let { errorScores[it] } ?: 0

    val hasIncorrectChar = errorScore > 0

    val middleScore = if (hasIncorrectChar) 0 else chars()
        .asSequence()
        .map { it.toChar() }
        .fold(ArrayDeque<Char>()) { queue, character ->
            val isClosing = character !in openers
            if (!isClosing) queue.addFirst(character) else queue.removeFirst()
            queue
        }
        .mapNotNull { openerToCloser[it] }
        .also { println(it) }
        .fold(0L) { score, char -> score * 5 + (middleScores[char] ?: 0) }

    return SyntaxCheck(errorScore > 0, errorScore, middleScore)
}
