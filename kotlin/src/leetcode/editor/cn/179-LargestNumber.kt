import java.util.*

//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出："1"
// 
//
// 示例 4： 
//
// 
//输入：nums = [10]
//输出："10"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 109 
// 
// Related Topics 排序 
// 👍 682 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun largestNumber(nums: IntArray): String {
        val array = Array(nums.size) { nums[it].toString() }

        // 字符串排序
        // 看到要求两个整数 x,y 如何拼接得到结果更大时，就想到先转字符串，然后比较 x+y 和 y+x
        Arrays.sort(array, Comparator<String> { s1, s2 ->
            return@Comparator (s2 + s1).compareTo(s1 + s2)
        })

        // [0,0]
        return if (array[0] == "0") {
            "0"
        } else {
            array.joinToString(separator = "") {
                it
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
