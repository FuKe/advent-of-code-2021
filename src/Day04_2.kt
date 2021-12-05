import models.BingoPlate

fun main() {
    val rawInput: List<String> = readInput("Day04.txt")

    val numbersToDrawn: List<Int> = rawInput[0].split(",").map { it.toInt() }
    val bingoPlates: List<BingoPlate> = parseBingoPlates(rawInput)

    val (winningNumber, lastPlateToWin) = play(numbersToDrawn, bingoPlates)
    val score = winningNumber * lastPlateToWin.sumOfUnmarkedNumbers()

    println("Last plate to win: \n")
    println(lastPlateToWin)
    println()
    println("Score: $score")
}

private fun play(numbersToDraw: List<Int>, plates: List<BingoPlate>): Pair<Int, BingoPlate> {
    var winningPlates: List<Pair<Int, BingoPlate>> = emptyList()

    numbersToDraw.forEach { num ->
        plates.forEach { plate ->
            if (!plate.hasCompleteColumn() && !plate.hasCompleteRow()) {
                if (plate.plateHasNumber(num)) {
                    plate.markNumber(num)
                }

                if (plate.hasCompleteColumn() || plate.hasCompleteRow()) {
                    winningPlates = winningPlates + Pair(num, plate)
                }
            }
        }
    }

    return winningPlates.last()
}
