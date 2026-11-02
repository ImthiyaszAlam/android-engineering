fun main(){
    val arr:intArrayOf(1,2,3,4,5,6,7,8,7,9)
    int target = 4
    firstLast(arr,target)
}

 fun firstLast(arr:IntArray,target:Int):IntArray{

    fun find (isFirst:Boolean):Int{


var l = 0
var r = arr.size-
var result = -1

while(l<=r){
    val  mid = l+(r-l)/2
    when{
        arr[mid] == target -> result = mid
        if(isFirst){
            r = mid-1
        }else{
            l = mid+1
        }
    }
            arr[mid] < target -> l = mid+1
          else-> r = mid-1
}
return result

    }
    return intArrayOf(find(true),find(false))
 }