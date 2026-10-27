fun main() {
    val nums = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

    println("even count: ${nums.count{it % 2==0}}")
    println("Has >4 ${nums.any{it>4}}")
    println("All >0 ${nums.all{it>0}}")
    println("None ${nums.all{it<0}}")
}
