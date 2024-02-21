package chapter5.lambda_collection

fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6)

    // filter 활용
    println(list.filter { it % 2 == 0 })

    // map 활용
    println(list.map { it * it })

    // 연쇄하여 사용
    println(list.filter { it % 2 == 0 }.map { it * it })

    // all
    println(list.all { it > 0 })

    // any
    println(list.any { it > 5 })

    // count
    list.count { it > 3 }

    // find
    list.find { it % 2 == 0 }
}
