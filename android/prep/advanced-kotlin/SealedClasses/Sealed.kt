sealed class Result

data class Success(val data: String) : Result()

data class Error(val message: String) : Result()

object Loading : Result()

fun handleResult(result: Result) {
    when (result) {
        is Success -> println("Successful")
        is Error -> println("Error")
        Loading -> println("Loading")
    }
}

fun main() {

    handleResult(Success("Successful"))
    handleResult(Error("Error"))
    handleResult(Loading)
}
