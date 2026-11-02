fun main(){
    val  arr = intArrayOf(1,1,4,1,1,1,2)
   println( isSorted(arr))
}

fun isSorted(arr:IntArray):Boolean{
    for(i in 1 until arr.size){
        if(arr[i]<arr[i-1]) return false;
    }

    return true;
}