package algo.programmers.P42895

class Solution {

    fun solution(N: Int, number: Int): Int {

        if (N == number) {
            return 1
        }

        // dp[숫자 횟수][그 때의 계산 값들]
        val dp = mutableListOf(mutableSetOf<Int>())

        repeat(8) {
            dp.add(mutableSetOf())
        }

        dp[1].add(N)

        for (i in 2..8) {
            // i 번 반복한 숫자 넣기
            dp[i].add(N.toString().repeat(i).toInt())

            for (j in 1 until i) {
                for (value1 in dp[j]) {
                    for (value2 in dp[i - j]) {
                        dp[i].add(value1 + value2)
                        dp[i].add(value1 * value2)
                        dp[i].add(value1 - value2)
                        try {
                            dp[i].add(value1 / value2)
                        } catch (_: Exception) {

                        }
                    }
                }
            }

            if (dp[i].contains(number)) {
                return i
            }
        }

        return -1
    }

}
