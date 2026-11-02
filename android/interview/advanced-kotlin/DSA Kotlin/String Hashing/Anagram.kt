fun main(){

val s1 = "alam"
val s2 = "mama"
val result = isAnagram(s1,s2)
print(result)
}


fun isAnagram(s1:String,s2:String):Boolean{

    val map = HashMap<Char,Int>()

    if(s1.length!=s2.length) return false

    for (c in s1) {
        map[c] = map.getOrDefault(c,0)+1
    }

    for(c in s2){
        map[c] = map.getOrDefault(c,0)-1
        if(map[c]!!<0) return false
    }

    return true
}