package algo.programmers.P181947

fun main() {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    println(a.toString() + " + " + b.toString() + " = " + (a + b))
}