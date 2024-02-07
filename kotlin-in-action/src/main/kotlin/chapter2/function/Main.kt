package chapter2.function

// 블록이 본문인 함수
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

// 식이 본문인 함수
fun max2(a: Int, b: Int) = if (a > b) a else b
