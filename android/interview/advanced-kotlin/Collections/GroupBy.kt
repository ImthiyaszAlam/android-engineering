fun main() {
    val names = listOf("Ali", "Sara", "Sahil", "Imthiyas", "Ali")
    println(names)
    val grouped = names.groupBy { it.first() }
    println(grouped)

    grouped.forEach { println(it) }
}
