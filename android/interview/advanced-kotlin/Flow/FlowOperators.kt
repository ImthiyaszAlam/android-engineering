fun simulatedFlow(): List<Int> {
    return (1..10).toList()
}

fun main() {

    println("Simulated Flow")
    val result = simulatedFlow().filter { it % 2 == 0 }.map { it * it }.take(3)

    println("Finally collected  $result")
}
