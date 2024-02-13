package chapter3.vararg_infix_library

fun main() {

    val arr = arrayOf(1, 2, 3, 4, 5)

    // 스프레드 연산자를 사용하여 가변 인자에 데이터를 넣을 수 있다.
    val list = listOf(*arr)

    println(list)
}
