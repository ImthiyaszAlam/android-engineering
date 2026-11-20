fun blockingTask(name: String) {
    println("$name :  Task started")
    Thread.sleep(1000)
    println("$name : Task Completed")
}

fun main() {
    println("Main starts")
    blockingTask("One")
    blockingTask("Two")
    println("Main Ends")
}
