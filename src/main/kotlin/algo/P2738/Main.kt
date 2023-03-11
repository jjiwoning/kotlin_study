package algo.P2738

fun main(args: Array<String>) {

    val s = readln().split(" ")

    val n = s[0].toInt()
    val m = s[1].toInt()

    val arr = Array(n) {IntArray(m)}

    addArr(arr)
    addArr(arr)

    for (i in arr.indices) {
        for (j in arr[i].indices) {
            print(arr[i][j])
            print(" ")
        }
        println()
    }
}

private fun addArr(arr: Array<IntArray>) {
    for (i in arr.indices) {
        val s1 = readln().split(" ")
        for (j in arr[i].indices) {
            arr[i][j] += s1[j].toInt();
        }
    }
}