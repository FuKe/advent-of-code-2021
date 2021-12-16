import java.util.*

private val pointMap: Map<String, Int> = mapOf(
    ")" to 3,
    "]" to 57,
    "}" to 1197,
    ">" to 25137
)

private val closes: Map<String, String> = mapOf(
    "(" to ")",
    "[" to "]",
    "{" to "}",
    "<" to ">"
)

fun main() {
    test()

    val puzzleInput: List<String> = readInput("Day10.txt")

    val aResult: Int = aSolver(puzzleInput)
    println("Part one result: $aResult")
}

private fun aSolver(puzzleInput: List<String>): Int {
    var pointResult = 0
    puzzleInput.forEach { chunk ->
        val open: Stack<String> = Stack()

        for (char in chunk) {
            val charStr: String = char.toString()

            if (charStr in closes.keys) {
                open.push(charStr)
            } else if (closes[open.peek()] == charStr) {
                open.pop()
            } else {
                pointResult += pointMap[charStr]!!
                break
            }
        }
    }

    return pointResult
}

private fun bSolver(puzzleInput: List<String>): Int {
    TODO()
}

private fun test() {
    val testInput: List<String> = listOf(
        "[({(<(())[]>[[{[]{<()<>>",
        "[(()[<>])]({[<{<<[]>>(",
        "{([(<{}[<>[]}>{[]{[(<()>",
        "(((({<>}<{<{<>}{[]{[]{}",
        "[[<[([]))<([[{}[[()]]]",
        "[{[{({}]{}}([{[{{{}}([]",
        "{<[[]]>}<{[{[{[]{()[[[]",
        "[<(<(<(<{}))><([]([]()",
        "<{([([[(<>()){}]>(<<{{",
        "<{([{{}}[<[[[<>{}]]]>[]]"
    )

    val aTestResult: Int = aSolver(testInput)
    check(aTestResult == 26397)
}
