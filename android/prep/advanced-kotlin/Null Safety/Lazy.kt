val config by lazy {
    println("Loaded config")
    "Secret Config"
}

fun main() {
    println("Before Using Config")
    println("config: $config")
}
