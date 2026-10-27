fun main() {

    val names = listOf("Alam", "", "Anna", "", "Alam2")
    val (valid, invalid) = names.partition { it.isNotBlank() }

    println("valid: $valid")
    println("invalid: $invalid")
    println("names: $names")
}
