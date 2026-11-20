fun main(){

var arr = intArrayOf(1,2,3,4,5,6,4,6,7,8,9)
println(reverseDupl(arr))
}


fun reverseDupl(arr:IntArray):Int{
    if(arr.isEmpty()) return 0


var slow = 0

for (fast in 1 until arr.size) {
    if(arr[fast]!=arr[slow]) {
        slow++;
        arr[slow] = arr[fast]
    }
}

return slow+1

}