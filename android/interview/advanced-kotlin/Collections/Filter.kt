fun main() {
    val nums = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    nums.forEach { num -> print(" Number : $num ") }

    val even = nums.filter { it % 2 == 0 }
    even.forEach { eve -> print("Even Number : $eve ") }
}
