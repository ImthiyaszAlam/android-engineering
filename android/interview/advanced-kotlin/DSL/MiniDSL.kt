class Task(val title: String) {
    var isDone = false

    fun done() {
        isDone = true
    }

    override fun toString(): String {
        return "[$title - ${if (isDone) " Done" else " Pending"}]"
    }
}

class TaskList {
    private val tasks = mutableListOf<Task>()

    fun task(title: String, block: Task.() -> Unit) {
        val t = Task(title)
        t.block()
        tasks.add(t)
    }

    fun showAll() {
        tasks.forEach { println(it) }
    }
}

fun taskList(block: TaskList.() -> Unit): TaskList {
    val list = TaskList()
    list.block()
    return list
}

fun main() {
    val myDay = taskList {
        task("Go Gym") {
            done()
        }

        task("Write Blog") {
            // not done
        }

        task("Push Code") {
            done()
        }
    }

    myDay.showAll()
}
