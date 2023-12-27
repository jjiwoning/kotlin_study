package algo.boj.P10713

import java.util.StringTokenizer
import kotlin.math.max
import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val routes = readLine().split(" ")
        .map { input -> input.toInt() }
        .toIntArray()

    val tickets = Array<Ticket?>(n + 1) { null }
    val sumArr = IntArray(n + 2) { 0 }

    for (i in 1 until n) {
        st = StringTokenizer(readLine())
        tickets[i] = Ticket(st.nextToken().toLong(), st.nextToken().toLong(), st.nextToken().toLong())
    }

    for (i in 1 until m) {
        val start = routes[i - 1]
        val end = routes[i]

        val lower = min(start, end)
        val higher = max(start, end)

        sumArr[lower]++
        sumArr[higher]--
    }

    for (i in 1..n + 1) {
        sumArr[i] += sumArr[i - 1]
    }

    var answer = 0L

    for (i in 1 until n) {
        val price1 = 1L * tickets[i]!!.price * sumArr[i]
        val price2 = 1L * tickets[i]!!.icTicketPrice + sumArr[i] * tickets[i]!!.useIcTicketPrice

        answer += min(price1, price2)
    }

    println(answer)
}

data class Ticket(
    val price: Long,
    val useIcTicketPrice: Long,
    val icTicketPrice: Long
)
