package coroutines.core

import kotlinx.coroutines.*

fun execute() {
    runBlocking {
        launch { // 부모 컨텍스트
            println("main: ${Thread.currentThread().name}")
        }

        launch(Dispatchers.Unconfined) { // 특정 스레드에 종속되지 않음 ? 메인 스레드 사용
            launch {
                println("Unconfined: ${Thread.currentThread().name}")
            }
        }

        launch(Dispatchers.Default) { // 기본 컨텍스트 왛용
            launch {
                println("Default: ${Thread.currentThread().name}")
            }
        }

        launch(newSingleThreadContext("CustomThread")) { // 새 스레드를 사용
            launch {
                println("newSingleThreadContext: ${Thread.currentThread().name}")
            }
        }
    }
}

fun main() {
    println("start!")
    execute()
    Thread.sleep(5000L)
    println("end!")
}

