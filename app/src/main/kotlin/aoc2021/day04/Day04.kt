package aoc2021.day04

import aoc2021.toFile

class Day04 {

    companion object {

        @JvmStatic
        fun part1(): Int {
            val lines = "input-day04.txt"
                .toFile()
                .readLines()

            val numbers = lines.first().split(",").map { it.toInt() }
            println("numbers: $numbers")

            //val boards = lines.drop(1).takeWhile { it.isNotBlank() }.toList().toBoard()

            val boards = mutableListOf<BingoBoard>()
            val l = mutableListOf<String>()
            lines.drop(2).forEach {
                println(it)
                if (it.isNotBlank()) l.add(it)
                //println("l: $l")
                if (it.isBlank()) {
                    boards.add(l.toBoard())
                    l.clear()
                }
            }

            println("boards: $boards")
            var winner : BingoBoard? = null
            val number = numbers.find { number ->
                boards.forEach { board -> board.update(number) }
                winner = boards.find { board -> board.bingo() }
                winner != null
            }

            println("Winner: $winner")
            println("number: $number")

            return winner!!.result(number!!)
        }

        @JvmStatic
        fun part2(): Int {
            val lines = "input-day04.txt"
                .toFile()
                .readLines()

            val numbers = lines.first().split(",").map { it.toInt() }
            println("numbers: $numbers")

            //val boards = lines.drop(1).takeWhile { it.isNotBlank() }.toList().toBoard()

            val boards = mutableListOf<BingoBoard>()
            val l = mutableListOf<String>()
            lines.drop(2).forEach {
                println(it)
                if (it.isNotBlank()) l.add(it)
                //println("l: $l")
                if (it.isBlank()) {
                    boards.add(l.toBoard())
                    l.clear()
                }
            }

            println("boards: $boards")
            val winners = mutableListOf<BingoBoard>()
            val number = numbers.find { number ->
                boards.forEach { board -> board.update(number) }
                boards.forEach { board -> if (board.bingo()) winners.add(board) }
                boards.removeIf { it.bingo() }
                boards.isEmpty()
            }

            println("Winner: ${winners.last()}")
            println("number: $number")

            return winners.last().result(number!!)
        }

        @JvmStatic
        fun main(args: Array<String>) {
            println(part1())
            println(part2())
        }
    }
}

private fun List<String>.toBoard(): BingoBoard {
    return BingoBoard(BingoGrid(this.map { it.split(" ").filter { it.isNotBlank() }.map { BingoField(it.toInt()) } } ))
}