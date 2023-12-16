package basic.type_alias

import basic.type_alias.b.hello1 as helloB // import와 동시에 이름 변경 가능
import basic.type_alias.a.hello1 as helloA

typealias Aclass = Anasdkjasndkjasbnfcnjkasbfcjasdbasjdbasd // type에 별칭 추가 가능

fun main() {
    val a = Aclass("hello", "hello2")
    helloA()
    helloB()

    val (b, c) = a // 구조 분해 -> data class의 componentN

    println(b)
    println(c)
}

data class Anasdkjasndkjasbnfcnjkasbfcjasdbasjdbasd(
    val hello: String,
    val hello2: String,
)
