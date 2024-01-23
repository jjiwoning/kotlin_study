package basic.collections.collection

import java.util.LinkedList

/**
 * 컬렉션이 가변인지 불변인지 선언부에서 지정해줘야 한다.
 * ex) List(불변), MutableList(가변)
 *
 * List<Int?> : list에 null 값이 들어갈 수 있지만 list 자체는 null이 아님
 * List<Int>? : list에 null 값이 들어갈 수 없지만 list 자체는 null이 가능
 * List<Int?>? : value list 둘 다 null 가능
 */
fun main() {

    // 불변 리스트
    val list = listOf(1, 2, 4, 3)
    val list2 = emptyList<Int>() // 타입 추론이 가능하다면 생략 가능하다.

    // get
    for (i in list.indices) {
        println(list[i])
    }

    // 가변 리스트
    val list3 = mutableListOf(1, 2, 3, 4)
    list3.add(7)
    println(list3[4])

    val list4 : MutableList<Int> = LinkedList<Int>()

    // map
    val map = mutableMapOf<String, Int>()
    map["hello"] = 3
    println(map["hello"])
}
