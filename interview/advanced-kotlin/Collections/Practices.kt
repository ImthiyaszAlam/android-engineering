fun main() {
    val item =
            listOf(
                    "Laptop" to 50000,
                    "Phone" to 35000,
                    "Tablet" to 25000,
                    "Monitor" to 15000,
                    "Mouse" to 2000
            )

    println(item)

    val expensive = item.filter { it.second >= 10000 }
    val affordable = item.filter { it.second <= 10000 }
    println("expensive items : $expensive")
    println("affordable items : $affordable")

    val labeled = item.map { "${it.first}: ${it.second}" }
    println("labeled items : $labeled")

    val totalPrice = item.map { it.second }.sum()
    println("totalPrice items : $totalPrice")
}
