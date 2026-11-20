data class Product(val id: Int, val productName: String)

fun main() {
    val products =
            listOf(
                    Product(1, "Pen"),
                    Product(2, "Pencil"),
                    Product(3, "Notebook"),
                    Product(4, "Adapter"),
            )
    println(products)
    products.forEach { println(it.id) }
    products.forEach { println(it.productName) }

    val grouped = products.groupBy { it.productName }
    println(grouped)

    val productMap = products.associateBy { it.id }
    println("productMap : $productMap")

    val pencil = productMap[2]?.productName
    val notebook = productMap[3]?.productName

    println("pencil : $pencil")
    println("notebook : $notebook")
}
