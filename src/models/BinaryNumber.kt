package models

class BinaryNumber(val bits: List<Bit>) {
    fun toNumeric(): Int =
        Integer.parseInt(toString(), 2)

    override fun toString(): String =
        bits.joinToString("")
}
