package chapter6.nothing

fun fail(message: String): Nothing {
    throw IllegalArgumentException("예외 발생~")
}
