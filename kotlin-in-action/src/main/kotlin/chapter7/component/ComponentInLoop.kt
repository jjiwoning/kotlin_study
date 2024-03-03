package chapter7.component

fun printEntries(map: Map<String, String>) {
    for ((key, value) in map) {
        println("${key} : ${value}")
    }
}
