



fun main(){

val array = intArrayOf(1,2,3,0,0,0,4,5,6,7,8,9)
moveZeroes(array)
println(array.joinToString())

}


fun moveZeroes(arr:IntArray){
    var slow  = 0

    for(fast in  arr.indices ){
        if(arr[fast]!=0){
            val temp = arr[slow]
            arr[slow] = arr[fast]
            arr[fast] = temp
            slow++
        }
    }
}