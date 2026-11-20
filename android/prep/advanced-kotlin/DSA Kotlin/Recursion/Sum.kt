fun main(){
    val num = 5
    printN(num)
}

fun printN(n:Int){
    if(n==0) return
    print("$n ")
    printN(n-1)
}