package algo.P2562

data class Node(val value : Int, val index : Int)

fun main(args: Array<String>) {

    val list = arrayListOf<Node>()

    for (i in 1..9) {
        val n = readln().toInt()
        list.add(Node(n, i))
    }

    list.sortByDescending { it.value }

    println(list[0].value)
    println(list[0].index)
}