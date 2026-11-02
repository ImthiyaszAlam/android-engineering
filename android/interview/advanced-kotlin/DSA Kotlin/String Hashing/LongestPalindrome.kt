fun main(){

}

fun longestPalindrome(s:String):Int{
    val set = HashSet<Char>()
    var length = 0


    for (c in s) {
        if(set.contains(s)){
            set.remove(c)
            length+=2

        }else{
            set.add(c)
        }
    } 
    return if(set.isNotEmpty()) length+1 else length
}