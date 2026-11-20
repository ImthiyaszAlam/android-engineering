fun main() {
    val name: String? = "Alam"

    val length = name?.length

    println("length $length")

    val language: String = "Kotlin"
    val result = language?.length

    println("result $result")

    val input: String? = null
    val output = input ?: "Not empty"
    println("output $output")

    val name1: String? = null
    val length1 = name!!.length
    println("length1 $length1")

    val email: String? = "alam@gmail.com"
    email.let { println("Email is : $email") }
}
