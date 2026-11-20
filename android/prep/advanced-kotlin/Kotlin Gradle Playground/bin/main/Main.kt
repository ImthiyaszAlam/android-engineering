import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Main Thread: ${Thread.currentThread().name}") 


    launch{
        delay(1000)
          println("Main Thread: ${Thread.currentThread().name}") 
    }
}
