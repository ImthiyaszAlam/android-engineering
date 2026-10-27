fun main() {

    val scores = listOf(95, 85, 100, 70, 60)
    val sorted = scores.sorted()
    println(sorted)

    val sortedDescending = scores.sortedDescending()
    println(sortedDescending)

    val users = listOf("Imthiyas" to 24, "Alam" to 20, "Harish" to 30)
    val sortByAge = users.sortedBy { it.second }
    println(sortByAge)
}
