fun main() {
    val nums = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val topStudents = nums.filter { it > 5 }.map { "Score: $it" }
    println(topStudents)
}
