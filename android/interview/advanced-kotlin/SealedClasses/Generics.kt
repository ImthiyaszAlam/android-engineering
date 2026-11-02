fun <T> getFirstItem(list: List<T>): T? {
    return list.firstOrNull()
}

fun <T> getLastItem(list: List<T>): T? {
    return list.lastOrNull()
}

fun main() {
    println("Generic Classes")
    println("Firrst element ")
    println(getFirstItem(listOf(1, 2, 3)))
    println(getFirstItem(listOf("alam", "anna", "kotlin")))

    println("Last element ")

    println(getLastItem(listOf(1, 2, 3)))
    println(getLastItem(listOf("alam", "anna", "kotlin")))
}
