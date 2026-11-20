data class User(var name: String, var age: Int, var grad: String, var major: String)

fun main() {

    val users =
            listOf(
                    User("Alam", 24, "B.Tech", "CSE"),
                    User("Alam", 24, "B.Tech", "CSE"),
                    User("Alam", 24, "B.Tech", "CSE"),
                    User("Alam", 24, "B.Tech", "CSE"),
                    User("Alam", 24, "B.Tech", "CSE"),
                    User("Alam", 24, "B.Tech", "CSE"),
                    User("Alam", 24, "B.Tech", "CSE"),
            )

    users.forEach { println(it) }
}
