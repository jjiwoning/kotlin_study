package algo.boj.P25304

fun main(args: Array<String>) {
    val totalMoney = readln().toLong()
    val n = readln().toInt()
    var result = 0L

    for (i in 1..n) {
        val (price, count) = readln().split(" ").map { it.toInt() }
        result += price * count;
    }

    if (totalMoney == result) {
        println("Yes")
        return
    }
    println("No")
}