sealed class LoginResult

data class SuccessFul(val userId: String) : LoginResult()

data class ErrorFul(val message: String) : LoginResult()

object Loadingg : LoginResult()

fun handleLogin(result: LoginResult) {
    when (result) {
        is SuccessFul -> println("Successful: ${result.userId}")
        is ErrorFul -> println("Error: ${result.message}")
        is Loadingg -> println("Loading")
    }
}

fun main() {

    handleLogin(Loadingg)
    handleLogin(SuccessFul("Success"))
    handleLogin(ErrorFul("Error"))
}
