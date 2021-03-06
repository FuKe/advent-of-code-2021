import models.BinaryNumber
import models.BingoPlate
import models.Bit
import java.io.File

/**
 * Reads lines from the given input file.
 */
fun readInput(name: String) = File("src", name).readLines()

fun String.toBinaryNumber(): BinaryNumber {
    val bits: List<Bit> = map {
        Bit(it.toString().toInt())
    }
    return BinaryNumber(bits)
}

fun filterByMostSignificantBit(input: List<BinaryNumber>, filterAtPosition: Int): List<BinaryNumber> {
    val mostSignificantBit: Bit = findMostSignificantBitAtPosition(input, filterAtPosition)
    var filtered: List<BinaryNumber> = input.filterByBitAtPosition(mostSignificantBit, filterAtPosition)

    if (filtered.size > 1) {
        filtered = filterByMostSignificantBit(filtered, filterAtPosition + 1)
    }
    return filtered
}

fun filterByLeastSignificantBit(input: List<BinaryNumber>, filterAtPosition: Int): List<BinaryNumber> {
    val leastSignificantBit: Bit = findLeastSignificantBitAtPosition(input, filterAtPosition)
    var filtered: List<BinaryNumber> = input.filterByBitAtPosition(leastSignificantBit, filterAtPosition)

    if (filtered.size > 1) {
        filtered = filterByLeastSignificantBit(filtered, filterAtPosition + 1)
    }
    return filtered
}

fun findMostSignificantBitAtPosition(bits: List<BinaryNumber>, position: Int): Bit {
    val bitsAtPosition: List<Bit> = bits.map {
        it.bits[position]
    }

    val zeroCount = bitsAtPosition.count { it.value == 0 }
    val oneCount =  bitsAtPosition.count { it.value == 1 }

    return if (zeroCount > oneCount) {
        Bit(0)
    } else {
        Bit(1)
    }
}

fun findLeastSignificantBitAtPosition(bits: List<BinaryNumber>, position: Int): Bit =
    findMostSignificantBitAtPosition(bits, position).flip()

fun List<BinaryNumber>.filterByBitAtPosition(bit: Bit, position: Int): List<BinaryNumber> =
    filter {
        it.bits[position] == bit
    }

fun parseBingoPlates(rawPuzzleInput: List<String>): List<BingoPlate> {
    var convertedPlates: List<BingoPlate> = emptyList()

    var plateRows: MutableList<List<Int>> = mutableListOf()
    // First bingo plate starts at index 2
    for (i in 2 until rawPuzzleInput.size) {
        val line: String = rawPuzzleInput[i]
        if (line.isBlank()) {
            val plate = BingoPlate(plateRows)
            convertedPlates = convertedPlates + plate
            plateRows = mutableListOf()
        } else {
            val bingoRow: List<Int> = line
                .split(" ")
                .filter {
                    it.isNotBlank()
                }
                .map { it.toInt() }

            plateRows += bingoRow
        }
    }

    return convertedPlates
}
