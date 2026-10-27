fun main(){
val str= "alammnnggtfrtded"
println(longestSubstring(str))
}



fun longestSubstring(str:String):Int{


var set = HashSet<Char>()
var left = 0
var maxLen = 0

for(right in str.indices){
    while(set.contains(str[right])){
        set.remove(str[left])
        left++
    }
    set.add(str[right])
    maxLen = maxOf(maxLen,right-left+1)
}
return maxLen;

}