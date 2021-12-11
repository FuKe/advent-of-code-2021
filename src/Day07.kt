import kotlin.math.abs

fun main() {
    test()

    val puzzleInput: List<Int> = readInput("Day07.txt")[0]
        .split(",")
        .map { it.toInt() }

    val aResult: Int = aSolver(puzzleInput)
    println("Part one result: $aResult")

    val bResult: Int = bSolver(puzzleInput)
    println("Part two result: $bResult")
}

private fun aSolver(puzzleInput: List<Int>): Int {
    val uniquePositions: Set<Int> = puzzleInput.toSet()
    var leastAmountOfFuel = Int.MAX_VALUE

    uniquePositions.forEach { position ->
        var sumFuelUsed = 0
        puzzleInput.forEach { submarinePosition ->
            sumFuelUsed += abs(submarinePosition - position)
        }

        if (sumFuelUsed < leastAmountOfFuel) {
            leastAmountOfFuel = sumFuelUsed
        }
    }

    return leastAmountOfFuel
}

private fun bSolver(puzzleInput: List<Int>): Int {
    val maxPosition: Int = puzzleInput.maxOrNull() ?: 0
    var leastAmountOfFuel = Int.MAX_VALUE

    for (position in 0 .. maxPosition) {
        var sumFuelUsed = 0
        puzzleInput.forEach { submarinePosition ->
            val steps: Int = abs(submarinePosition - position)
            for (i in 1 .. steps) {
                sumFuelUsed += i
            }
        }

        if (sumFuelUsed < leastAmountOfFuel) {
            leastAmountOfFuel = sumFuelUsed
        }
    }

    return leastAmountOfFuel
}

private fun test() {
    val input: List<Int> = listOf(16, 1, 2, 0, 4, 2, 7, 1, 2, 14)

    val aResult: Int = aSolver(input)
    check(aResult == 37)

    val bResult: Int = bSolver(input)
    check(bResult == 168)
}
