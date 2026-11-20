fun main(){
val n = 5
printN(n)
}


fun printN(n:Int){
        if(n==0) return
        print("$n ")
        printN(n-1)
}