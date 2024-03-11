package algo.boj.P20006

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())

    val p = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val users = arrayListOf<User>()

    for (i in 0 until p) {
        st = StringTokenizer(readLine())

        val level = st.nextToken().toInt()
        val name = st.nextToken()

        users.add(User(name, level, false))
    }

    for (index in users.indices) {
        if (!users[index].check) {
            val room = arrayListOf<User>()
            val limit = users[index].level

            for (i in index until users.size) {
                if (room.size == m) {
                    break
                }
                if (!users[i].check && users[i].level >= limit - 10 && users[i].level <= limit + 10) {
                    users[i].check = true
                    room.add(users[i])
                }
            }

            if (room.size == m) {
                println("Started!")
                room.sortBy { it.name }
                for (user in room) {
                    println("${user.level} ${user.name}")
                }
            }

            if (room.size != m) {
                println("Waiting!")
                room.sortBy { it.name }
                for (user in room) {
                    println("${user.level} ${user.name}")
                }
            }
        }
    }
}

data class User(
    val name: String,
    val level: Int,
    var check: Boolean
)
