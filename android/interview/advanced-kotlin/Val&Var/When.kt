fun main() {

    val day = 3

    val result =
            when (day) {
                1 -> "Monday"
                2 -> "Teuesday"
                3 -> "Wednesday"
                4 -> "Tursday"
                5 -> "Friday"
                6 -> "Saturday"
                else -> "Sunday"
            }

    println(result)
}
