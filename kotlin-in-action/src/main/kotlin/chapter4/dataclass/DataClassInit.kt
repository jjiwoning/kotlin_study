package chapter4.dataclass

// equals, hashCode, toString 자동으로 생성해준다.
data class Client2(
    private val name: String,
    private val postalCode: Int
)

fun main() {
    val client = Client2(name = "hello", postalCode = 123)

    val copy = client.copy(name = "hello2")
}
