import kotlinx.coroutines.*

suspend fun fetch(): String {
    delay(1000)
    return "✅ Coroutine completed"
}

fun main() = runBlocking {
    println("Started")
    val result = fetch()
    println(result)
}