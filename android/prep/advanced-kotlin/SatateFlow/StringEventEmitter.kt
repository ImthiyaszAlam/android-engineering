class StringEventEmitter{
    private val collectors = mutableStateOf<(String)->Unit>()

    fun emit(event:String){
        collectors.forEach{collector->
        collector(event)

        }
    }

    fun collect(collector:(String)->Unit){
collectors.add()
    }

}

fun main() {
    val eventSystem = StringEventEmitter()

    eventSystem.collect { event ->
        println(" Event Received: $event")
    }

    eventSystem.emit("Show Toast")
    eventSystem.emit("Open Profile Page")
}