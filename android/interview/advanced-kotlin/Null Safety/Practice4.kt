fun main() {
    val techStack = mutableListOf("Kotlin", "Compose", "Android")
    println(techStack)

    val summary =
            with(techStack) {
                add("Coroutines")
                add("Flow")
                "Size $size"
            }
    println(summary)
}
