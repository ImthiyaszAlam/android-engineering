data class CartItem(val id: Int, val item: String, val price: Double)

fun main() {

    val cartItems =
            listOf(
                    CartItem(1, "Book", 10.0),
                    CartItem(2, "Pen", 10.0),
                    CartItem(3, "Pencil", 10.0),
                    CartItem(4, "Laptop", 10000.0),
                    CartItem(5, "Mouse", 1000.0),
                    CartItem(6, "Monitor", 10000.0),
            )

    val total = cartItems.fold(0.0) { acc, item -> acc + item.price }

    println("total: $total")
}
