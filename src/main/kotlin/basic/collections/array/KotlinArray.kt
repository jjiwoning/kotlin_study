package basic.collections.array

/**
 * Kotlin 배열
 */
fun main() {

    val arr: Array<Int> = arrayOf(1, 2, 3, 4)

    for (i in arr.indices) {
        println(arr[i])
    }

    val plus = arr.plus(5) // kotlin에서 배열에 값을 추가하는 방법

    for ((index, value) in plus.withIndex()) {
        println("$index $value")
    }

}