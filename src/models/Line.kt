package models

data class Point(
    val x: Int,
    val y: Int
) {
    override fun toString(): String =
        "$x,$y"
}

data class Line(
    val start: Point,
    val end: Point
) {
    fun isHorizontal(): Boolean =
        start.y == end.y

    fun isVertical(): Boolean =
        start.x == end.x

    fun pointsCovered(): List<Point> =
        if (isHorizontal()) {
            (start.x .. end.x).map { Point(it, start.y) }
        } else if (isHorizontal()) {
            (start.y .. end.y).map { Point(start.x, it) }
        } else {
            emptyList()
        }

    fun hasOverlap(other: Line): Boolean {
        val pointsCovered: List<Point> = pointsCovered()
        return other.pointsCovered().any {
            it in pointsCovered
        }
    }

    override fun toString(): String =
        "$start -> $end"
}
