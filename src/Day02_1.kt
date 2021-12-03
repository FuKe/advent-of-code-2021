fun main() {
    val puzzleInput: List<String> = readInput("Day02.txt")

    var horizontalPosition = 0
    var depth = 0

    puzzleInput.forEach {
        val (instruction, value) = it.split(' ')
        when (instruction) {
            "forward" -> horizontalPosition += value.toInt()
            "down" -> depth += value.toInt()
            "up" -> depth -= value.toInt()
        }
    }

    print("Result (position and depth multiplied): ${horizontalPosition * depth}")
}
