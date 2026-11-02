fun simpleFlow(): List<Int> {
    val emittedValues = mutableListOf<Int>()

    for (i in 1..5) {
        println("emitting: $i")
        Thread.sleep(2000)
        emittedValues.add(i)
    }

    return emittedValues
}

fun main() {

    println("Collecting values")
    val values = simpleFlow()
    for (value in values) {
        println("Collected $value")
    }
}
