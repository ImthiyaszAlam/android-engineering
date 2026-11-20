class User(val name: String) {

    companion object {
        const val TYPE = "Regular"
        fun createGuest(): User = User("Guest")
    }
}

fun main() {
    val guest = User.createGuest()
    println("${guest.name}, ${User.TYPE}")
}
