fun main() {
    val puzzleInput: List<String> = readInput("Day02.txt")

    var horizontalPosition = 0
    var depth = 0
    var aim = 0

    puzzleInput.forEach {
        val (instruction, value) = it.split(' ')
        when (instruction) {
            "forward" -> {
                horizontalPosition += value.toInt()
                depth += aim * value.toInt()
            }
            "down" -> aim += value.toInt()
            "up" -> aim -= value.toInt()
        }
    }

    print("Result (position and depth multiplied): ${horizontalPosition * depth}")
}
