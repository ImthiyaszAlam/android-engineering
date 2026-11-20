data class Category(val id: Int, val name: String, val items: List<String>)

fun main() {

    val categories =
            listOf(
                    Category(1, "fruits", listOf("banana", "apple")),
                    Category(2, "veggies", listOf("carror", "spinach")),
                    Category(3, "non-veg", listOf("chicken", "salmon"))
            )

    println("Simple: $categories")

    categories.forEach {
        it.items
        println("forEach:    ${it.items}")
    }

    val grouped = categories.groupBy { it.name }
    println("groupBy:    ${grouped}")

    val categoriesMap = categories.associateBy { it.name }
   val item1 = categoriesMap["veggies"]?.name
    println("item1:    ${item1}")

    val allItems = categories.flatMap { it.items }
       println("allItems:    ${allItems}")
}
