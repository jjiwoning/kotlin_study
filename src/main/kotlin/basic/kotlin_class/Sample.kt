package basic.kotlin_class

data class Sample(val name: String, val type: String, val num: Int, var own: Boolean) {
    fun hello() {
        println("안녕하세요")
    }
}
