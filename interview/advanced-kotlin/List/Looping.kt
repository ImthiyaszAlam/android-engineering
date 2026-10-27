fun main() {
    val tools = listOf("Android studio", "VS CODE", "IntellijIdea")

    println(" $tools")

    for ((index, tool) in tools.withIndex()) {
        println("Tool $index : $tool")
    }
}
