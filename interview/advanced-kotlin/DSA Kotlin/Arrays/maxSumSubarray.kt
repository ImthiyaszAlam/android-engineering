fun main(){

    val arr = intArrayOf(1,32,5,62,3,4,7,8)
    val k = 4
   
    println( subArraySum(arr,k))
}


fun subArraySum(arr:IntArray,k:Int):Int{
    
    var sum = 0
    var max = Int.MIN_VALUE


    for (i in arr.indices) {
        sum+=arr[i]
        if(i>=k-1){
            max = maxOf(max,sum)
            sum-=arr[i-k+1]
        }
    }

    return max;
}
