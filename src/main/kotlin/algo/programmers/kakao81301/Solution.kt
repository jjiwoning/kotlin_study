package algo.programmers.kakao81301

class Solution {

    val map: MutableMap<String, String> = HashMap()

    fun solution(s: String): Int {
        initMap()
        return replaceAllStringToNumber(s)
    }

    private fun replaceAllStringToNumber(s: String): Int {
        var replaceString: String = s
        for (key in map.keys) {
            replaceString = replaceString.replace(key, map[key].toString())
        }
        return replaceString.toInt()
    }

    private fun initMap() {
        map["zero"] = "0"
        map["one"] = "1"
        map["two"] = "2"
        map["three"] = "3"
        map["four"] = "4"
        map["five"] = "5"
        map["six"] = "6"
        map["seven"] = "7"
        map["eight"] = "8"
        map["nine"] = "9"
    }
}