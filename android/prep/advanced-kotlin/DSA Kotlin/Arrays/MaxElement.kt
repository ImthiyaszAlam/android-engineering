
 fun maxElement(arr:IntArray):Int{
    var  max =arr[0]
for (i in arr) {
    if(i>max){
        max = i;
    }

}
    return max
}

fun main(){

val arr= intArrayOf(1,2,3,4,5,6,7,8);
println(maxElement(arr))



}