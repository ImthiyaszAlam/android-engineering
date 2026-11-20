fun greet(name: String) {

    println("Good Morning $name")
}

fun add(a: Int, b: Int): Int {
    val sum: Int = a + b

    return sum
}

fun main() {
    val name = "Alam"
    greet(name)

    val a = 5
    val b = 3

    println(add(a, b))
}
