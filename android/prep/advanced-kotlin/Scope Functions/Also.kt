fun main() {
    val list = mutableListOf(1, 2, 3)
    println(list)

    list.forEach { a -> print(a) }

    list.also { println("message $it") }.add(4)

    list.forEach { listItem -> print("listItem: $listItem") }

    println("Last $list")
}
