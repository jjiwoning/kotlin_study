package basic.collections.collection

fun main() {
    val fruits = listOf(
        Fruit(1L, "apple", 1000L, 2000L),
        Fruit(2L, "tomato", 1000L, 2000L),
        Fruit(3L, "mellon", 1000L, 2000L),
        Fruit(4L, "water-mellon", 1000L, 2000L),
        Fruit(5L, "apple", 1000L, 2000L),
        Fruit(6L, "orange", 1000L, 2000L),
        Fruit(7L, "apple", 1000L, 2000L),
        Fruit(8L, "apple", 1000L, 2000L),
        Fruit(9L, "orange", 15000L, 2000L),
        Fruit(10L, "apple", 1000L, 2000L),
        Fruit(11L, "mellon", 1000L, 2000L)
    )

    val result = fruits
        .filter { fruit -> fruit.name == "apple" }

    for (fruit in result) {
        println(fruit)
    }

    println("================================")

    val result2 = fruits
        .filter { fruit -> fruit.name == "apple" }
        .map { fruit -> fruit.currentPrice }

    for (price in result2) {
        println(price)
    }

    println("================================")

    fruits
        .filter { fruit -> fruit.name == "apple" }
        .mapNotNull { fruit -> fruit.currentPrice } // null이 아닌 값 만 mapping 가능

    val result3 = fruits.all { it.name == "apple" } // 리스트의 모든 원소가 해당 식을 true로 리턴해야 true
    val result4 = fruits.none { it.name == "apple" } // 리스트의 모든 원소가 해당 식을 false로 리턴해야 true
    val result5 = fruits.any { it.name == "apple" } // 리스트의 단 하나라도 원소가 해당 식을 만족하면 true

    println(result3)
    println(result4)
    println(result5)

    println("================================")

    val count = fruits.count()

    val sortedResult = fruits.sortedBy { fruit -> fruit.name } // 순차 정렬
    val reverseSortedResult = fruits.sortedByDescending { fruit -> fruit.name } // 역순 정렬

    for (fruit in sortedResult) {
        println(fruit)
    }

    println("================================")

    val result6 = fruits.distinctBy { it.name }

    for (fruit in result6) {
        println(fruit)
    }

    println("================================")

    fruits.first()
    fruits.last()

    // list -> map (multi value)
    val result7: Map<String, List<Fruit>> = fruits.groupBy { fruit -> fruit.name }
    val result9: Map<String, List<Long>> = fruits.groupBy({fruit -> fruit.name}, {fruit -> fruit.factoryPrice})

    // list -> map (unique)
    val result8: Map<Long, Fruit> = fruits.associateBy { fruit -> fruit.id }

    // flatMap, flatten
}

data class Fruit(
    val id: Long,
    val name: String,
    val factoryPrice: Long,
    val currentPrice: Long?
)
