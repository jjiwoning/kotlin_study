package chapter2.enumandwhen

import chapter2.enumandwhen.Color.*

enum class Color(
    val r: Int,
    val g: Int,
    val b: Int
) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255);

    fun rgb() = (r * 256 + g) * 256 + b
}

fun getMnemonic(color: Color): String {
    return when (color) {
        RED -> "Richard"
        ORANGE -> "Of"
        YELLOW -> "York"
        GREEN, BLUE -> "Gave"
    }
}

fun mix(c1: Color, c2: Color): Color {
    return when (setOf(c1, c2)) {
        setOf(RED, YELLOW) -> ORANGE
        setOf(YELLOW, BLUE) -> GREEN
        else -> throw IllegalArgumentException("Dirty Color ;P")
    }
}

fun mixOptimized(c1: Color, c2: Color) {
    when {
        (c1 == RED && c2 == YELLOW) || (c1 == YELLOW && c2 == RED) -> ORANGE
        else -> throw IllegalArgumentException("Dirty Color ;P")
    }
}

interface Expr

class Num(val value: Int) : Expr

class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int {
    if (e is Num) {
        return e.value
    }
    if (e is Sum) {
        return eval(e.right) + eval(e.left)
    }
    throw IllegalArgumentException("Unknown Expression!")
}

fun evalRefactor(e: Expr): Int {
    return when (e) {
        is Num -> e.value
        is Sum -> eval(e.left) + eval(e.right)
        else -> throw IllegalArgumentException("Unknown Expression!")
    }
}
