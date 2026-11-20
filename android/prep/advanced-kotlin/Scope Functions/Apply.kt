fun main() {

    data class User(var name: String, var age: Int, var occupation: String)
    val user =
            User("Alam", 25, "Android Engineer").apply {
                name = "Imthiyas"
                age = 24
            }

    println(user)
}
