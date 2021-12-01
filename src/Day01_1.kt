fun main() {
    val puzzleInput: List<Int> = readInput("Day01.txt").map { it.toInt() }

    var measurements = 0
    puzzleInput.forEachIndexed { i, n ->
        if (i != 0 && n > puzzleInput[i-1]) {
            measurements++
        }
    }

    println("Measurements larger than the previous measurement: $measurements")
}
