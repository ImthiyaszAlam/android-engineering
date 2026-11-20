fun main() {
    val items = listOf("a", "b", "c", "d", "e", "f")
    val grid = items.chunked(3)
    println("Grid: $grid")
}
