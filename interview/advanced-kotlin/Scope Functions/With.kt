fun main() {

    val list = mutableListOf("elements", "element1", "element2")
    val result =
            with(list) {
                add("Alam")
                size
            }

    println("Size: $result")
}
