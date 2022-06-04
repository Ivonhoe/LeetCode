class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        hashMapOf<Int, Int>().apply{
            nums.forEachIndexed{ index, number ->
                var other = target - number
                if(containsKey(other)){
                    val otherIndex = get(other)?:0
                    return intArrayOf(otherIndex, index)
                }
                put(number, index)
            }
        }

        return intArrayOf()
    }
}