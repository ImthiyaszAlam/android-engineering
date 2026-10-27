fun String.addHashTag(): String {
    return "#$this"
}

fun Int.addNumber(): Int {
    return this + 123
}

fun Int.subNum(): Int {
    return this - 2
}

fun Int.mulNum(): Int {
    return this * this
}

fun Int.addNum(): String {
    return this.toString() + "anna"
}

fun main() {
    val word = "Koltin"
    val aadedHashTag = word.addHashTag()
    println(aadedHashTag)

    val num = 12

    println(num.addNumber())

    println(num.subNum())

    println(num.mulNum())
}
