package basic.kotlin_class.data_class

/**
 * data class
 * equals, hashCode, toString, getter, setter 모두 자동 생성해준다.
 */
data class PersonDto(
    val name: String,
    val age: Int
)

fun main() {
    val personDto = PersonDto("tamtam", 12)
    println(personDto)
    println(personDto.hashCode())
}
