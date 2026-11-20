// A reusable class to emit and listen to events
class EventEmitter<T> {
    // This list will hold all listeners/subscribers
    private val collectors = mutableListOf<(T) -> Unit>()

    // This function sends an event to all subscribers
    fun emit(event: T) {
        for (collector in collectors) {
            collector(event) // Call each listener with the event
        }
    }

    // This function lets someone start listening
    fun collect(collector: (T) -> Unit) {
        collectors.add(collector)
    }
}

fun main() {
    // Create an event system that works with Strings
    val toastEvents = EventEmitter<String>()

    // Subscribe to listen for string events
    toastEvents.collect { message ->
        println("🔔 Toast: $message")
    }

    // Send some events
    toastEvents.emit("Login Successful")
    toastEvents.emit("Please check your internet")
}
