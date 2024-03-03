package chapter7.component

import chapter7.Point

data class NameComponents(val name: String, val extension: String)

fun splitFilename(fullName: String): NameComponents {
    val result = fullName.split(".", limit = 2)
    return NameComponents(result[0], result[1])
}

fun main() {
    val p = Point(10, 20)
    val (x, y) = p // 구조 분해 사용

    val (name, ext) = splitFilename("example.kt")
}
