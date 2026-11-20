fun main(){
val arr=intArrayOf(1,2,3,4,5)
println(binarySearch(arr,5))
}


fun binarySearch(arr:IntArray,target:Int):Int{
    var l = 0
    var r = arr.size-1;
    while(l<=r){
        val mid = l+(r-l)/2
        when{
            arr[mid] == target->return mid
            arr[mid]<target -> l=mid+1
            else-> r=mid-1
        }
    }
    return -1
}