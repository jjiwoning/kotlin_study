package chapter6.nullable

fun <T : Any> printHashCode(t: T) {
    println(t.hashCode())
}
