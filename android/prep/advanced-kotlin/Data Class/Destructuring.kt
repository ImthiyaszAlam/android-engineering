data class Developer(var name: String, var language: String, var EOE: Int)

fun main() {

    val dev1 = Developer("Alam", "Kolin", 1)
    val dev2 = Developer("RandomDev", "Java", 2)
    val dev3 = Developer("WebDev", "JavaScript", 3)
    val dev4 = Developer("FlutterDev", "Flutter", 2)

    val deelopers = listOf(dev1, dev2, dev3, dev4)
    deelopers.forEach {
        val (devName, DevLang, devEO) = it
        println("$devName loves $DevLang having $devEO years of Experinece")
    }
}
