package chapter4.dataclass

class Client(
    private val name: String,
    private val postalCode: Int
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Client

        if (name != other.name) return false
        if (postalCode != other.postalCode) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + postalCode
        return result
    }

    override fun toString(): String {
        return "Client(name='$name', postalCode=$postalCode)"
    }

}
