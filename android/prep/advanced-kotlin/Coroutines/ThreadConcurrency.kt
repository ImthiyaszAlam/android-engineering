fun asyncTask(name: String) {
    Thread {
                println("$name : Task stated")
                Thread.sleep(1000)
                println("$name : Task finished")
            }
            .start()
}

fun main() {
    println("Main starts")

    asyncTask("task-1")
    asyncTask("task-2")
    println("Main ends (while tasks still running)")
    Thread.sleep(2000)
    println("After 2000")
}
