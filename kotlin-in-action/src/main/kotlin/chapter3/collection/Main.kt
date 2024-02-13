package chapter3.collection

fun main() {
    // 컬렉션 생성 방법
    val set = hashSetOf(1, 2, 3)
    val list = arrayListOf(1, 2, 3)
    val map = hashMapOf(1 to "one", 2 to "two", 3 to "three")

    // Java 컬렉션을 사용함
    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)

    // Kotlin의 컬렉션이 더 많은 기능을 제공한다.
    val lastNumber = list.last()
    val maxNumber = set.maxOrNull()
}
