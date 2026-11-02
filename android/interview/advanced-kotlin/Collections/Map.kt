fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)
    val squares = numbers.map { it * it }
    println("$squares")

    val number = listOf(1, 2, 3, 4, 5)
    val sum = number.map { it + it }
    println(sum)
}
