package chapter6.nullable

import java.util.*

fun main() {
    val s: String? = null // null이 가능한 타입
    val s2: String = "hello" // null이 불가능한 타입

    // s.length -> null이 가능한 타입은 특정 메서드를 호출할 수 없음

    val result = s?.length // s: null -> null s: value -> method return value

    // Kotlin의 확장 함수를 활용한 Null check
    s.isNullOrBlank()
    s.isNullOrEmpty()
}

fun printAllCaps(s: String?) {
    val allCaps: String? = s?.uppercase(Locale.getDefault())
    println(allCaps)
}
