fun main(){
    var n = 5
    val result = printFaactorial(n)
    print(result)
}

fun printFaactorial( n:Int):Int{
    if(n == 0) return 1
    return n * printFaactorial(n-1)
}