fun main() {
    val nums = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val result = nums.reduce { acc, i -> acc - i }
    println("Sum: $result")

    val numbers = listOf(1, 2, 3)
    val resultFold = numbers.fold(100) { a, i -> a - i }
    println("resultFold: $resultFold")
}
