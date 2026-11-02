class ContainsDuplicate {
    
    fun  containsDuplicate(nums: IntArray):Boolean {
        for (i in nums.indices) {
            for(j in i+1 until nums.size){
                if(nums[i] == nums[j]){
                    return true
                }
            }
        }
        return false
    }
}

 fun main(args: Array<String>) {
    val duplicate = containsDuplicate()
    val nums = IntArrayOf(1,1,0,1,1,1,1)
    println(duplicate.containsDuplicate(nums))
}