fun main(){

}

fun permute(nums:IntArray):List<List<Int>>{
    val result = mutableListOf<List<Integer>>
    val used = BooleanArray(nums.size)

    fun dfs(current:MutableListOf<Int>){
        if(current.size = nums.size){
        result.add(ArrayList<current>)
        return
        }

        for (i in nums.indices) {
            if(used[i] continue)
            used[i] = true
            current.add(nums[i])

            dfs(current)

            current.removeAt(current.size-1)
            used[i] = false

        }
    }
    dfs(mutableListOf())
    return res

}