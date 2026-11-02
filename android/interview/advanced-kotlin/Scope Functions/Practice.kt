fun main() {
    data class Developer(var name: String, var language: String)
    val dev = Developer("Alam", "Kotlin")
    println(dev)
    dev
            .apply {
                name = "Imthiyas"
                language = "KotlinJava"
            }
            .also { println("Setup complete for $it") }
            .run { println("Working with $language") }
    val result = "Jetpack Compose".let { it.replace(" ", "_").uppercase() }
    println(result)

    val numbers = mutableListOf(1, 2, 3)
    val size =
            with(numbers) {
                add(4)
                add(5)
                size
            }

    println("Final List: $numbers , $size ")
}
