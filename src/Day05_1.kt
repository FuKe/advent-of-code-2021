import models.Line
import models.Point

fun main() {
    val puzzleInput: List<Line> = readInput("Day05.txt").map { it.toLine() }

    puzzleInput.forEach {
        println(it)
    }

    val horizontalVertical: List<Line> = puzzleInput.filter {
        it.isHorizontal() || it.isVertical()
    }

    val allPoints: List<Point> = horizontalVertical.flatMap { it.pointsCovered() }

}

private fun String.toLine(): Line {
    val (leftSide, rightSide) = split(" -> ")
    val (x1, y1) = leftSide.split(",")
    val (x2, y2) = rightSide.split(",")

    val start = Point(x1.toInt(), y1.toInt())
    val end = Point(x2.toInt(), y2.toInt())

    return Line(start, end)
}
