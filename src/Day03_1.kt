fun main() {
    val puzzleInput: List<String> = readInput("Day03.txt")

    val bitPositionMap: MutableMap<Int, MutableList<Int>> = mutableMapOf()
    puzzleInput.map { binaryString ->
        binaryString.forEachIndexed { index, char ->
            val numeric: Int = char.toString().toInt()
            if (!bitPositionMap.containsKey(index)) {
                bitPositionMap[index] = mutableListOf(numeric)
            } else {
                bitPositionMap[index]?.plusAssign(numeric)
            }
        }
    }

    var gammaBinary = ""
    var epsilonBinary = ""
    bitPositionMap.map { (_, bits) ->
        val zeroCount = bits.count { bit -> bit == 0 }
        val oneCount = bits.count { bit -> bit == 1 }

        if (zeroCount > oneCount) {
            gammaBinary += "0"
            epsilonBinary += "1"
        } else {
            gammaBinary += "1"
            epsilonBinary += "0"
        }
    }

    val gammaNumeric: Int = Integer.parseInt(gammaBinary, 2)
    val epsilonNumeric: Int = Integer.parseInt(epsilonBinary, 2)
    val powerConsumption = gammaNumeric * epsilonNumeric

    println("Total power consumption: $powerConsumption")
}
