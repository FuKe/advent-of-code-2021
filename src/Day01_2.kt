fun main() {
    val puzzleInput: List<Int> = readInput("Day01.txt").map { it.toInt() }
    val sums: List<Int> = calculateSlidingWindowSums(puzzleInput)

    var measurements = 0
    sums.forEachIndexed { i, n ->
        if (i != 0 && n > sums[i-1]) {
            measurements++
        }
    }

    println("Measurements larger than the previous measurement: $measurements")
}

fun calculateSlidingWindowSums(input: List<Int>): List<Int> =
    input.mapIndexed { i, n ->
        if (i < 2) {
            null
        } else {
            n + input[i-1] + input[i-2]
        }
    }.filterNotNull()
