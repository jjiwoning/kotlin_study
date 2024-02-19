package chapter5.lambda

fun printMessageWithPrefix(message: Collection<String>, prefix: String) {
    message.forEach {
        println("${prefix} ${it}")
    }
}

fun printProblemCounts(responses: Collection<String>) {
    var clientErrorCount = 0
    var serverErrorCount = 0

    responses.forEach {
        if (it.startsWith("4")) {
            clientErrorCount++
        }
        if (it.startsWith("5")) {
            serverErrorCount++
        }
    }
}

/**
 * 람다 변수 포획 방법
 */
class Ref<T>(var value: T)

val counter = Ref(0)
val inc = { counter.value++ }

var count = 0
val inc2 = { count++ }
