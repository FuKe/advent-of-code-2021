package models

import java.util.*

class Bit(
    val value: Int
) {
    init {
        check(value == 0 || value == 1)
    }

    fun flip(): Bit =
        if (value == 0) {
            Bit(1)
        } else {
            Bit(0)
        }

    override fun equals(other: Any?): Boolean =
        other is Bit && other.value == value

    override fun hashCode(): Int =
        Objects.hash(value)

    override fun toString(): String =
        value.toString()
}
