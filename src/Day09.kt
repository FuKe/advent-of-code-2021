fun main() {
    val puzzleInput: List<List<Int>> = parseInput(readInput("Day09.txt"))

    val aResult: Int = aSolver(puzzleInput)
    println("Part one result: $aResult")

//    val bResult: Int = bSolver(puzzleInput)
//    println("Part two result: $bResult")
}

private fun aSolver(puzzleInput: List<List<Int>>): Int {
    val lowPoints: MutableList<Int> = mutableListOf()

    puzzleInput.forEachIndexed { rowIndex, list ->
        list.forEachIndexed { heightIndex, height ->
            val above: Int = if (rowIndex > 0) {
                puzzleInput[rowIndex - 1][heightIndex]
            } else { Int.MAX_VALUE }

            val left: Int = if (heightIndex > 0) {
                puzzleInput[rowIndex][heightIndex - 1]
            } else { Int.MAX_VALUE }

            val below: Int = if (rowIndex < puzzleInput.size - 1) {
                puzzleInput[rowIndex + 1][heightIndex]
            } else { Int.MAX_VALUE }

            val right: Int = if (heightIndex < list.size -1 ) {
                puzzleInput[rowIndex][heightIndex + 1]
            } else { Int.MAX_VALUE }

            if (height < above && height < left && height < below && height < right) {
                lowPoints += height
            }
        }
    }

    return lowPoints.sumOf { it + 1 }
}

private fun bSolver(puzzleInput: List<List<Int>>): Int {
    TODO()
}

private fun parseInput(input: List<String>): List<List<Int>> {
    return input.map { line ->
        line.map { it.toString().toInt() }
    }
}

private fun test() {
    val exampleInput = listOf(
        "2199943210",
        "3987894921",
        "9856789892",
        "8767896789",
        "9899965678"
    )
    val puzzleInput: List<List<Int>> = parseInput(exampleInput)

    val aResult: Int = aSolver(puzzleInput)
    check(aResult == 15)
}
