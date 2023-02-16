package algo.P1931

data class Meeting(var start: Int, var end: Int)

fun main() {

    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()

    val meetings = arrayOfNulls<Meeting>(n)

    for (i in meetings.indices) {
        val strings = br.readLine().split(" ")
        meetings[i] = Meeting(strings[0].toInt(), strings[1].toInt())
    }

    meetings.sortWith(compareBy({it?.end}, {it?.start}))

    var answer = 0
    var time = 0

    for (i in meetings.indices) {
        if (time <= (meetings[i]?.start ?: 0)) {
            answer++
            time = meetings[i]?.end ?: 0
        }
    }

    println(answer)
}