//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 926 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        var result = IntArray(2) {
            -1
        }
        if (nums == null || nums.isEmpty()) {
            return result
        }

        var firstPostion = findFirstPosition(nums, target);
        var lastPostion = findLastPosition(nums, target);
        result[0] = firstPostion
        result[1] = lastPostion
        return result
    }

    private fun findFirstPosition(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1

        while (l <= r) {
            var middle = (l + r) / 2
            if (nums[middle] > target) {
                r = middle - 1
            } else if (nums[middle] < target) {
                l = middle + 1
            } else {
                if (middle == 0 || nums[middle - 1] != target) {
                    return middle
                } else {
                    r = middle - 1
                }
            }
        }

        return -1
    }

    private fun findLastPosition(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1

        while (l <= r) {
            var middle = (l + r) / 2
            if (nums[middle] > target) {
                r = middle - 1
            } else if (nums[middle] < target) {
                l = middle + 1
            } else {
                if (middle == nums.size - 1 || nums[middle + 1] != target) {
                    return middle
                } else {
                    l = middle + 1
                }
            }
        }

        return -1
    }
}
//leetcode submit region end(Prohibit modification and deletion)
