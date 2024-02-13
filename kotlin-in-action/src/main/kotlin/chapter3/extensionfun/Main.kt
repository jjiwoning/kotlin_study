package chapter3.extensionfun

// 확장 함수 String: 수신 객체 타입, this: 수신 객체
fun String.lastChar(): Char = this[this.length - 1]

// 확장 프로퍼티
val String.lastChar: Char
    get() = this[length - 1]

var StringBuilder.lastChar: Char
    get() = this[this.length - 1]
    set(value: Char) {
        this.setCharAt(length - 1, value)
    }

fun main() {
    // 확장 함수 사용
    val lastChar = "hello".lastChar()
    println(lastChar)

    // 확장 프로퍼티 사용
    val lastChar2 = "hello".lastChar
    println(lastChar2)

    val sb = StringBuilder("hello")
    sb.lastChar = 'O'
    println(sb)
    println(sb.lastChar)

    val list = listOf(1, 2, 3, 4, 5, 6)
    println(list.joinToString())
}

// 확장 함수로 작성한 joinToString 메서드
fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) {
            result.append(separator)
        }
        result.append(element)
    }

    return result.append(postfix).toString()
}

// 더 구체적인 타입을 수신 객체 타입으로 지정할 수 있다.
fun Collection<String>.join(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
) = joinToString(separator, prefix, postfix)
