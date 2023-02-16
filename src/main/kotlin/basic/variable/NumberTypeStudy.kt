package basic.variable

import java.lang.StringBuilder

data class Sample(var number: Int, var s: String)

fun main() {

    val s: String
    s = "basic/hello"
    //s = "tamtam" // 재할당 불가능

    var s1: String
    s1 = "world"
    s1 = "world2" // 재할당 가능

    val sample = Sample(number = 10, s = "basic/hello")
    sample.s = "tamtam"
    println(sample.number)
    println(sample.s)

    val a : Int?
    a = null

    val s2 = "Hello"
    val s3 = String(StringBuilder("Hello"))
    val s4 = "Hello1"

    println(s2 == s3)
    println(s2 === s3)
    println(s2 === s4)
    println(s2.equals(s4))
    println(s2 == "Hello")
}