data class Message(val sender: String, val text: String)

fun main() {
    val messages =
            listOf(
                    Message("Alam", "Try not missing me hard?"),
                    Message("Anna", "Entha da Mhn"),
                    Message("She", "Why would i even miss you?"),
                    Message("Alam", "You can't be comfortable with your bed"),
                    Message("AlamAnna", "Athokke enikkum manassilavum mhn"),
            )

    messages.forEach { println(it.text) }

    val grouped = messages.groupBy { it.sender }
    println(grouped)
}
