fun main() {

    val result = operate(5, 10) { a, b -> a + b }
    println(result)

    val sub = subtract(20, 10) { x, y -> x - y }
    println(sub)
}

fun operate(x: Int, y: Int, op: (Int, Int) -> Int): Int {
    return (op(x, y))
}

fun subtract(a: Int, b: Int, sub: (Int, Int) -> Int): Int {
    return (sub(a, b))
}
