package chapter6.collection

val list1: List<Int?> = arrayListOf() // 원소가 null이 될 수 있는 리스트
val list2: List<Int>? = arrayListOf() // 리스트가 null이 될 수 있는 리스트

fun <T> copyElements(
    source: Collection<T>, // 읽기 전용 컬렉션
    target: MutableCollection<T> // 변경 가능한 컬렉션
) {
    for (item in source) {
        target.add(item)
    }
}
