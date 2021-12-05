package models

const val ANSI_YELLOW = "\u001B[33m"
const val ANSI_RESET = "\u001B[0m"

class BingoPlate(
    val rows: List<List<Int>>
) {
    init {
        check(rows.size == 5)
    }

    private var markedNumbers: List<Int> = emptyList()

    fun markNumber(num: Int) {
        assert(plateHasNumber(num))
        markedNumbers = markedNumbers + num
    }

    fun plateHasNumber(num: Int): Boolean =
        rows.any { row ->
            row.any { it == num }
        }

    fun hasCompleteRow(): Boolean =
        rows.any { row ->
            row.all {
                it in markedNumbers
            }
        }

    fun hasCompleteColumn(): Boolean {
        val columns: List<MutableList<Int>> = listOf(
            mutableListOf(), mutableListOf(), mutableListOf(), mutableListOf(), mutableListOf()
        )

        rows.forEachIndexed { _, row ->
            row.forEachIndexed { colIndex, num ->
                columns[colIndex].add(num)
            }
        }

        return columns.any { column ->
            column.all {
                it in markedNumbers
            }
        }
    }

    fun sumOfUnmarkedNumbers(): Int =
        rows.flatten()
            .filter { it !in markedNumbers }
            .sum()

    override fun toString(): String =
        rows.joinToString("\n") {
            it.joinToString { num ->
                var str = if (num < 10) {
                    "  $num"
                } else {
                    " $num"
                }
                if (num in markedNumbers) {
                    str = "$ANSI_YELLOW$str$ANSI_RESET"
                }
                str
            }
        }
}
