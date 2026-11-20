fun main() {

    val numbers = mutableListOf(1, 2, 3, 4, 5, 6, 7)

    numbers.map { it * 3 }.filter { it % 2 != 0 }.forEach { it -> println(" $it") }
}
