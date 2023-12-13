package basic.lambda

/**
 * Java에서는 함수 자체가 값이 될 수 없다. -> 인터페이스로 functional인척 구현하는 것임
 * Kotlin은 함수 자체가 값이 될 수 있다. -> Java와의 차이점
 */
fun main() {
    val animals = listOf(
        Animal("tamtam", "dog"),
        Animal("hosi", "dog"),
        Animal("tamtan", "cat"),
        Animal("tam", "dog"),
        Animal("tantam", "horse"),
        Animal("tatam", "panda"),
        Animal("ta", "tiger")
    )

    // lambda 선언 방법 1
    val isDog: (Animal) -> Boolean = fun(animal: Animal): Boolean {
        return animal.spec == "dog"
    }

    // lambda 선언 방법 2
    val isDog2: (Animal) -> Boolean = { animal: Animal -> animal.spec == "dog" }

    val result = filterAnimal(animals, isDog)

    result.forEach { println(it) }

    println("=========")

    val result2 = filterAnimal(animals) { it.spec == "cat" }

    result2.forEach { println(it) }
}

fun filterAnimal(
    animals: List<Animal>,
    filter: (Animal) -> Boolean
): List<Animal> {
    return animals.filter(filter).toCollection(mutableListOf())
}

data class Animal(
    val name: String,
    val spec: String
)
