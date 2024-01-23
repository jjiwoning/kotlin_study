package algo.boj.P21942

import java.util.StringTokenizer
import java.util.TreeMap

val info = mutableMapOf<String, MutableMap<String, Long>>()
val penaltyTimes = TreeMap<String, Long>()

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())

    val n = st.nextToken().toInt()
    val timeLimit = st.nextToken()
    val penalty = st.nextToken().toInt()

    val expireMin = parseTimeLimitToMin(timeLimit)

    for (i in 0 until n) {
        st = StringTokenizer(readLine())
        val date = st.nextToken()
        val time = st.nextToken()
        val productName = st.nextToken()
        val memberName = st.nextToken()

        var min = parseDayToMin(parseDateToDay(date))
        min += parseTimeToMin(time)

        if (!info.containsKey(memberName)) {
            info[memberName] = mutableMapOf()
            info[memberName]!![productName] = min
            continue
        }

        val memberProducts = info[memberName]!!
        if (memberProducts.containsKey(productName)) {
            if (min - memberProducts[productName]!! > expireMin) {
                penaltyTimes[memberName] = penaltyTimes
                    .getOrDefault(memberName, 0) + (min - memberProducts[productName]!! - expireMin) * penalty
            }
            memberProducts.remove(productName)
            continue
        }

        if (!memberProducts.containsKey(productName)) {
            memberProducts[productName] = min
        }
    }

    if (penaltyTimes.isEmpty()) {
        println(-1)
        return
    }

    for ((name, value) in penaltyTimes) {
        println("${name} ${value}")
    }
}

fun parseTimeLimitToMin(timeLimit: String): Long {
    var min = 0L

    val times = timeLimit.split("/")
    val day = times[0]

    min += parseDayToMin(day.toLong())
    min += parseTimeToMin(times[1])

    return min
}

fun parseTimeToMin(time: String): Long {
    val hourAndMin = time.split(":")
    return parseHour(hourAndMin[0].toLong()) + hourAndMin[1].toLong()
}

fun parseDateToDay(date: String): Long {
    var day = 0L

    val dates = date.split("-")
    day += parseMonth(dates[1].toLong())
    day += dates[2].toLong()

    return day
}

fun parseMonth(month: Long): Long {
    return when (month) {
        1L -> 0L
        2L -> 31L
        3L -> 31L + 28L
        4L -> 31L + 28L + 31L
        5L -> 31L + 28L + 31L + 30L
        6L -> 31L + 28L + 31L + 30L + 31L
        7L -> 31L + 28L + 31L + 30L + 31L + 30L
        8L -> 31L + 28L + 31L + 30L + 31L + 30L + 31L
        9L -> 31L + 28L + 31L + 30L + 31L + 30L + 31L + 31L
        10L -> 31L + 28L + 31L + 30L + 31L + 30L + 31L + 31L + 30L
        11L -> 31L + 28L + 31L + 30L + 31L + 30L + 31L + 31L + 30L + 31L
        12L -> 31L + 28L + 31L + 30L + 31L + 30L + 31L + 31L + 30L + 31L + 30L
        else -> throw IllegalArgumentException()
    }
}

fun parseDayToMin(day: Long): Long {
    return day * 24 * 60
}

fun parseHour(hour: Long): Long {
    return hour * 60
}
