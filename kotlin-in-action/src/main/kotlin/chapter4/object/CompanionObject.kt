package chapter4.`object`

class A {
    companion object B {
        fun hello() {
            println("hello")
        }
    }
}

fun main() {
    // 2가지 방법 모두 가능
    A.B.hello()
    A.hello()
}

class Request private constructor(val id: Long, val nickname: String) {
    companion object {
        fun of(id: Long, nickname: String): Request {
            return Request(id, nickname)
        }
    }
}
