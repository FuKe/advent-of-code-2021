import models.BingoPlate

fun main() {
    val rawInput: List<String> = readInput("Day04.txt")

    val numbersToDrawn: List<Int> = rawInput[0].split(",").map { it.toInt() }
    val bingoPlates: List<BingoPlate> = parseBingoPlates(rawInput)

    val (winningNumber, winnerPlate) = play(numbersToDrawn, bingoPlates)
    val score = winningNumber * winnerPlate.sumOfUnmarkedNumbers()

    println("Winning plate: \n")
    println(winnerPlate)
    println()
    println("Score: $score")
}

// Returns the last number drawn when a winner was found and the winning bingo plate.
fun play(numbersToDraw: List<Int>, plates: List<BingoPlate>): Pair<Int, BingoPlate> {
    numbersToDraw.forEach { num ->
        plates.forEach { plate ->
            if (plate.plateHasNumber(num)) {
                plate.markNumber(num)
            }
            if (plate.hasCompleteColumn() || plate.hasCompleteRow()) {
                return Pair(num, plate)
            }
        }
    }

    throw RuntimeException("No winning bingo plate was found!")
}
