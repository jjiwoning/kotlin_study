package algo.boj.P11401

const val CONST = 1000000007

fun main() {
    var answer: Long = 1L
    val (n, r) = readln().split(" ").map { it.toInt() }

    if (n == 0) {
        println(1)
        return
    }

    for (i in 1..n) {
        answer *= i
        answer %= CONST
    }

    val m = n - r

    var nMinusRFactorial = 1L

    for (i in 1..m) {
        nMinusRFactorial *= i
        nMinusRFactorial %= CONST
    }
    nMinusRFactorial = getPowerValue(nMinusRFactorial, CONST - 2) % CONST


    var rFactorial = 1L
    for (i in 1 .. r) {
        rFactorial *= i
        rFactorial %= CONST
    }
    rFactorial = getPowerValue(rFactorial, CONST - 2) % CONST
    answer *= nMinusRFactorial
    answer %= CONST
    answer *= rFactorial
    answer %= CONST

    println(answer)
}

fun getPowerValue(value: Long, power: Int): Long {
    if (power == 0) {
        return 1
    }

    val halfResult: Long = getPowerValue(value, power / 2) % CONST
    var result: Long = (halfResult.toLong() % CONST * halfResult % CONST) % CONST
    if (power % 2 == 1) {
        result = (result * value) % CONST
    }
    return result % CONST
}