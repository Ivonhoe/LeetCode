//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 
// 👍 109 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1
        var ans = 0

        while (l <= r) {
            var middle = (l + r) / 2
            if (nums[middle] > target) {
                r = middle - 1
            } else if (nums[middle] < target) {
                l = middle + 1
            } else {
                var index = middle
                while (index < nums.size) {
                    if (nums[index] == target) {
                        ans++
                        index = index + 1
                    } else {
                        break
                    }
                }

                index = middle - 1
                while (index >= 0) {
                    if (nums[index] == target) {
                        ans++
                        index -= 1
                    } else {
                        break
                    }
                }
                return ans
            }
        }
        return 0
    }
}
//leetcode submit region end(Prohibit modification and deletion)
