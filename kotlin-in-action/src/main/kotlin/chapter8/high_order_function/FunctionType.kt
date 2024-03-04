package chapter8.high_order_function

fun main() {
    val sum = { x: Int, y: Int -> x + y }
    val action = { println(42) }

    twoAndThree { a, b -> a + b }
}

fun performRequest(
    url: String,
    callback: (code: Int, content: String) -> Unit // 함수 타입의 각 파라미터에 이름을 붙인다.
) {

}

fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println("result = ${result}")
}
