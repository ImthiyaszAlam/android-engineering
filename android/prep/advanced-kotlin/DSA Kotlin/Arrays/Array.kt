

fun reverseArray(arr:IntArray){

    var i = 0;
    var j = arr.size-1;

    while(i<j){

val temp = arr[i]
arr[i] = arr[j];
arr[j] = temp;
i++;
j--
    }
  
}


fun main(){
    val arr = intArrayOf(1,2,3,4,5,6,7,8)
    reverseArray(arr)
    println(arr.joinToString())
} 