package aoc2021.day05

data class Point(val x: Int, val y: Int) {
    operator fun rangeTo(point: Point): List<Point> {
        val minY = minOf(y, point.y)
        val maxY = maxOf(y, point.y)
        val minX = minOf(x, point.x)
        val maxX = maxOf(x, point.x)
        return when {
            // vertical line
            x == point.x -> (minY..maxY).map { curY -> Point(x, curY) }//.also { println(it) }

            // horizontal line
            y == point.y -> (minX..maxX).map { curX -> Point(curX, y) }//.also { println(it) }

            // diagonal line
            else -> {
                when {
                    x <= point.x && y <= point.y -> (x..point.x).mapIndexed { index, curX ->
                        Point(
                            curX,
                            y + index
                        )
                    }//.also { println(it) }
                    x > point.x && y <= point.y -> (y..point.y).mapIndexed { index, curY ->
                        Point(
                            x - index,
                            curY
                        )
                    }//.also { println(it) }
                    x <= point.x && y > point.y -> (x..point.x).mapIndexed { index, curX ->
                        Point(
                            curX,
                            y - index
                        )
                    }//.also { println(it) }
                    else -> (point.x..x).mapIndexed { index, _ -> Point(x - index, y - index) }//.also { println(it) }
                }

//                // 8,0 -> 0,8 /
//                // 0,0 -> 8,8 \
//                if (y < point.y) {
//                    (minX..maxX).mapIndexed { index, curX -> Point(curX, minY + index) }.also { println(it) }
//                }
//                else {
//                    (minX..maxX).mapIndexed { index, curX -> Point(curX, maxY - index) }.also { println(it) }
//                }
//                // (minX..maxX).mapIndexed { index, curX -> Point(curX, minY + index) }
            }
        }
    }
}