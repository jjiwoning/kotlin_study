package algo.programmers.kakao42888

const val GET_MESSAGE = "님이 들어왔습니다."
const val LEAVE_MESSAGE = "님이 나갔습니다."

class Solution {

    fun solution(record: Array<String>): Array<String> {
        val answer = ArrayList<User>()
        val map = HashMap<String, String>()

        for (s in record) {
            val split = s.split(" ")
            if ("Enter" == split[0]) {
                answer.add(User(split[1], GET_MESSAGE))
                map[split[1]] = split[2]
            }

            if ("Leave" == split[0]) {
                answer.add(User(split[1], LEAVE_MESSAGE))
            }

            if ("Change" == split[0]) {
                map[split[1]] = split[2]
            }
        }

        return answer
            .map { it.parseMessage(map) }
            .toTypedArray()
    }
}

data class User(var id: String, var message: String) {
    fun parseMessage(map: Map<String, String>): String {
        return map[id] + message
    }
}
