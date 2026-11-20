fun simulateAsync(name: String, dayMillis: Long) {
    Thread {
                println("$name : started")
                Thread.sleep(dayMillis)
                println("$name : finished")
            }
            .start()
}

fun main() {

    println("Main begins")
    simulateAsync("alam", 1000)
    simulateAsync("anna", 1000)
    println("Main ends quickly")

    Thread.sleep(2000)
    println("Main ends finally after ${Thread.sleep(2000)}")
}
