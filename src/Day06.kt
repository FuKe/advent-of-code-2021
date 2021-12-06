fun main() {
    test()

    val puzzleInput: List<Int> = readInput("Day06.txt")[0]
        .split(",")
        .map { it.toInt() }


    val partOneResult: Int = partOne(puzzleInput)
    println("Part one result: $partOneResult")

    val partTwoResult: Long = partTwo(puzzleInput)
    println("Part two result: $partTwoResult")
}

fun partOne(initialFish: List<Int>): Int {
    val result: MutableList<Int> = initialFish.toMutableList()

    for (i in 1 .. 80) {
        val newFish: MutableList<Int> = mutableListOf()
        for (n in 0 until result.size) {
            var fish: Int = result[n] - 1
            if (fish < 0) {
                fish = 6
                newFish += 8
            }
            result[n] = fish
        }

        result += newFish
    }

    return result.size
}

fun partTwo(initialFish: List<Int>): Long {
    var cycleMap: MutableMap<Int, Long> = mutableMapOf(
        0 to 0,
        1 to 0,
        2 to 0,
        3 to 0,
        4 to 0,
        5 to 0,
        6 to 0,
        7 to 0,
        8 to 0,
    )

    initialFish.forEach {
        cycleMap[it] = cycleMap[it]!! + 1
    }

    for (n in 1 .. 256) {
        cycleMap = simulateDay(cycleMap)
    }

    return cycleMap.values.sum()
}

fun simulateDay(fishMap: MutableMap<Int, Long>): MutableMap<Int, Long> {
    return mutableMapOf(
        0 to fishMap[1]!!,
        1 to fishMap[2]!!,
        2 to fishMap[3]!!,
        3 to fishMap[4]!!,
        4 to fishMap[5]!!,
        5 to fishMap[6]!!,
        6 to fishMap[7]!! + fishMap[0]!!,
        7 to fishMap[8]!!,
        8 to fishMap[0]!!
    )
}

fun test() {
    val initialState: List<Int> = listOf(3, 4, 3, 1, 2)
    val partOneResult = partOne(initialState)
    check(partOneResult == 5934)

    val partTwoResult = partTwo(initialState)
    check(partTwoResult == 26984457539)
}
