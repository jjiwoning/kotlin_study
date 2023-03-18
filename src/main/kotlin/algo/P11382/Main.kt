package algo.P11382

fun main(args: Array<String>) {
    val (x, y, z) = readln().split(" ").map { it.toBigInteger() }
    println(x.add(y).add(z))
}