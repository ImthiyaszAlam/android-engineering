enum class Status {
    SUCCESS,
    LOADING,
    ERROR
}

fun showStatus(status: Status) {
    when (status) {
        Status.SUCCESS -> println("Operation successful")
        Status.LOADING -> println("Operation Loading")
        Status.ERROR -> println("Operation Error")
    }
}

fun main() {

    showStatus(Status.ERROR)
}
