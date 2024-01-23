package basic.variable

/**
 * 코틀린에서는 null이 가능한 타입을 다르게 취급한다.
 * 만약에 null 이슈가 발생할 수 있는 코드를 작성하면 코틀린 컴파일러가 실행을 못 하게 막는다.
 * 코틀린에는 null이 가능한 타입을 위한 기능들이 있다. -> safe-call, Elvis
 * null이 가능한 코드지만 null이 무조건 아닌 경우 null 아님으로 코드 작성 가능 -> !! 연산자
 * 진짜 무조건 Null이 아닐 때만 사용
 */
fun main() {

    // safe-call
    val s: String? = "ABC"
    // println(s.length) // 불가능 코틀린 컴파일러가 막는다.
    println(s?.length) // s가 null이면 뒤의 문장이 실행되지 않고, 전체가 null이 된다.

    // Elvis 연산자
    val s1: String? = null
    println(s1?.length ?: 1) // 앞의 연산 결과가 null이면 ?: 뒤의 값을 출력

    println(startsWithA("ABC"))
}

// 기존 자바 함수를 코틀린으로 옮기는 과정
fun startsWithA1(str: String?): Boolean { // ?로 null 가능한 코드임을 명시, return이 boolean
    if (str == null) {
        throw IllegalArgumentException("null이 들어옴")
    }
    return str.startsWith("A")
}

// 위 함수 리팩토링
fun startsWithA1Refactor(str: String?): Boolean {
    return str?.startsWith("A")
        ?: throw IllegalArgumentException("null 들어옴")
}

fun startsWithA2(str: String?): Boolean? { // return이 Boolean
    if (str == null) {
        throw IllegalArgumentException("null이 들어옴")
    }
    return str.startsWith("A")
}

// 위 함수 리팩토링
fun startsWithA2Refactor(str: String?): Boolean? {
    return str?.startsWith("A")
}

fun startsWithA3(str: String?): Boolean { // return이 Boolean
    if (str == null) {
        return false
    }
    return str.startsWith("A")
}

// 위 함수 리팩토링
fun startsWithA3Refactor(str: String?): Boolean {
    return str?.startsWith("A") ?: false
}

// safe-call
fun startsWithA4(str: String?): Boolean? { // ?로 null 가능한 코드임을 명시, return이 boolean
    return str?.startsWith("A") // safe-call : null이면 실행하지 않고, null이 아니면 실행한다.
}

// !! 연산자
fun startsWithA(str: String?): Boolean {
    return str!!.startsWith("A") // 컴파일러한테 소리를 지른다.
}