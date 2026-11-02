fun fakeSuspend(name: String, dayMillis: Long) {
    println("$name : Starting simulated suspend")
    Thread.sleep(dayMillis)
    println("$name: Ending simulated suspend")
}

fun main() {

    println("Main start")
    fakeSuspend("Network Request", 1500)
    println("Main end")
}
