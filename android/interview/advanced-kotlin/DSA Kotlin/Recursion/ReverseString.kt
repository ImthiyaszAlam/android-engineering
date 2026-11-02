fun main(){
    val name = "alam"
    val result = reverseString(name)
    print(result)
}

fun reverseString(s:String,i:Int = 0):String{
    if(i ==s.length) return ""

    return reverseString(s,i+1)+s[i]

}


