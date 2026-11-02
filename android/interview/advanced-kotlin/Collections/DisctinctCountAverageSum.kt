fun main() {

    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8)
    val unique = list.distinct()
    val total = list.count()
    val uniqueTotal = unique.count()
    val sum = list.sum()
    val average = list.average()

    println("unique : $unique")
    println("total : $total")
    println("uniqueTotal : $uniqueTotal")
    println("total : $total")
    println("sum : $sum")
    println("average : $average")
}
