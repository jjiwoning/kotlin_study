package chapter6.nullable

fun foo(s: String?) {
    val t: String = s ?: "" // s가 null이면 ""
    val t2: String = s ?: throw IllegalArgumentException()
}
