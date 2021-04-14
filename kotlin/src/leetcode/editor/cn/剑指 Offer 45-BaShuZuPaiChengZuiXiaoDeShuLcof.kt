import java.util.*
import kotlin.Comparator

//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
//
// 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: "3033459" 
//
// 
//
// 提示: 
//
// 
// 0 < nums.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
// Related Topics 排序 
// 👍 195 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun minNumber(nums: IntArray): String {
        val array = Array(nums.size) { nums[it].toString() }

        // 字符串排序
        // 看到要求两个整数 x,y 如何拼接得到结果更大时，就想到先转字符串，然后比较 x+y 和 y+x
        Arrays.sort(array, Comparator<String> { s1, s2 ->
            return@Comparator (s1 + s2).compareTo(s2 + s1)
        })

        return array.joinToString(separator = "") {
            it
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
