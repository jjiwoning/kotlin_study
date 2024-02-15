package chapter4.constructor

class User5(val name: String) {

    var address: String = "none"
        set(value: String) {
            println(
                """
                    Address was changed for ${name}:
                    "${field} -> ${value}
                """.trimIndent()
            )
            field = value
        }
}

class LengthCounter {
    var counter: Int = 0
        private set

    fun addWord(word: String) {
        counter += word.length
    }
}
