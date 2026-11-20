typealias Email = String

typealias userId = Int

data class Accout(val id: userId, val email: Email)

fun main() {
    val account = Accout(123, "email@gmail.com")
    println(account)
}
