fun main() {
    val email: String? = "alam@gmail.com"
    email?.let {
        if (it.endsWith("@gmail.com")) {
            println("Valid Email: $it")
        } else {
            println("Invalid Email: $it")
        }
    }
}
