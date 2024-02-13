package chapter3.makefunez

var number = 0 // 최상위 프로퍼티

const val DEFAULT_NUMBER = -1

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)

    joinToString(
        collection = numbers,
        separator = ":",
        prefix = "(",
        postfix = ")"
    )

    // default parameter 활용
    joinToString(numbers)
    joinToString(numbers, "!")

    // named parameter 활용
    joinToString(numbers, postfix = "!")
}

fun <T> joinToString(
    collection: Collection<T>,
    separator: String = ", ", // default parameter
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()) {
        if (index > 0) {
            result.append(separator)
        }
        result.append(element)
    }

    result.append(postfix)

    return result.toString()
}
