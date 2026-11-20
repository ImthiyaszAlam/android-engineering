sealed class UiState

data class Success(val data: String) : UiState()

data class Error(val message: String) : UiState()

data class Failed(val message: String) : UiState()

object Loading : UiState()

fun render(state: UiState) {
    when (state) {
        is Success -> println("Success: ${state.data}")
        is Error -> println("Error: ${state.message}")
        is Failed -> println("Failed: ${state.message}")
        is Loading -> println("Loading")
        else -> println("Waiting")
    }
}

fun main() {
    val currentState1: UiState = Success("Successful")
    val currentState2: UiState = Error("Error")
    val currentState3: UiState = Failed("Failed")

    render(currentState1)
    render(currentState2)
    render(currentState3)
}
