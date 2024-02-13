package chapter3.strings

fun main() {
    val s = "12.345-6.A"

    val split1 = s.split(".") // 그냥 문자를 바탕으로 split
    println(split1)

    val split2 = s.split("[.\\-]".toRegex()) // 정규식을 바탕으로 split
    println(split2)
}
