infix fun String.connectTo(other: String): String {
    return " $this <-> $other "
}

fun main() {
    val result = "imthiyas" connectTo "Alam"
    println(result)
}
