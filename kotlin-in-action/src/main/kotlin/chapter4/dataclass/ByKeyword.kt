package chapter4.dataclass

class DelegatingCollection<T>(
    private val innerList: MutableList<T> = ArrayList()
) : MutableList<T> by innerList {

    var count = 0

    override fun add(element: T): Boolean {
        count++
        return innerList.add(element)
    }
}
