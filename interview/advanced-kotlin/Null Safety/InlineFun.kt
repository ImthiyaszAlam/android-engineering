inline fun operate(a: Int, b: Int, op: (Int, Int) -> Int): Int {
    return op(a, b)
}

inline fun product(a: Int, b: Int, pro: (Int, Int) -> Int): Int {
    return pro(a, b)
}

inline fun calculateSum(a: Int, b: Int, sum: (Int, Int) -> Int): Int {
    return sum(a, b)
}

inline fun calculateDivision(x: Int, y: Int, divide: (Int, Int) -> Int): Int {
    return divide(x, y)
}

inline fun WriteName(a: String, b: String, name: (String, String) -> String): String {
    return name(a, b)
}

fun main() {
    val result = operate(5, 2) { x, y -> x * y }
    println(result)
    val result1 = product(3, 5) { a, b -> a * b }
    println(result1)

    val sum = calculateSum(2, 2) { a, b -> a + b }
    println(sum)

    val division = calculateDivision(10, 100) { x, y -> y / x }
    println(division)

    val name = WriteName("Alam", "imthiyas") { a, b -> " $b $a" }
    println(name)
}
