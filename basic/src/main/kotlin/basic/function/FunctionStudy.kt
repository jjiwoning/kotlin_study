package basic.function

fun test1(a: Int, b: Int): Int {
    return a + b
}

fun test2(a: Int, b: Int) = a + b

fun main() {
    val a = 10
    val b = 20
    println(test1(a, b))
    println(test2(a, b))
}
