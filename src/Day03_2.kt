import models.BinaryNumber

fun main() {
    val puzzleInput: List<BinaryNumber> = readInput("Day03.txt").map { it.toBinaryNumber() }

    val oxygenGeneratorRating: Int = findOxygenGeneratorRating(puzzleInput)
    val co2ScrubberRating: Int = findCo2ScrubberRating(puzzleInput)
    val lifeSupportRating: Int = oxygenGeneratorRating * co2ScrubberRating

    println("Oxygen generator rating: $oxygenGeneratorRating")
    println("Co2 Scrubber rating: $co2ScrubberRating")
    println("Life support rating: $lifeSupportRating")
}

fun findOxygenGeneratorRating(input: List<BinaryNumber>): Int {
    val filtered: List<BinaryNumber> = filterByMostSignificantBit(input, 0)
    assert(filtered.size == 1)

    return filtered[0].toNumeric()
}

fun findCo2ScrubberRating(input: List<BinaryNumber>): Int {
    val filtered: List<BinaryNumber> = filterByLeastSignificantBit(input, 0)
    assert(filtered.size == 1)

    return filtered[0].toNumeric()
}
