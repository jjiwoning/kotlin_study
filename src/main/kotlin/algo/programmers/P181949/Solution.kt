package algo.programmers.P181949

fun main(args: Array<String>) {
    val s1 = readLine()!!
    for (c in s1) {
        if (c.isLowerCase()) {
            print(c.uppercase())
        }
        if (c.isUpperCase()) {
            print(c.lowercase())
        }
    }
}