fun main(){
    val s ="maam"

    val result = isPalindrome(s,0,s.length-1)
    print(result)
}

fun isPalindrome(s:String,l:Int=0,r:Int =s.length-1):Boolean{
    if(l>=r){
        return true
    }

    if(s[l]!=s[r]){return false}
    return isPalindrome(s,l+1,r-1)
}