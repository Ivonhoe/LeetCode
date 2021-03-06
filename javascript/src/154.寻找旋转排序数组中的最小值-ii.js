/*
 * @lc app=leetcode.cn id=154 lang=javascript
 *
 * [154] 寻找旋转排序数组中的最小值 II
 *
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/description/
 *
 * algorithms
 * Hard (48.53%)
 * Likes:    124
 * Dislikes: 0
 * Total Accepted:    25.9K
 * Total Submissions: 53.2K
 * Testcase Example:  '[1,3,5]'
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 * ( 例如，数组 [0,1,2,4,5,6,7]  可能变为 [4,5,6,7,0,1,2] )。
 * 
 * 请找出其中最小的元素。
 * 
 * 注意数组中可能存在重复的元素。
 * 
 * 示例 1：
 * 
 * 输入: [1,3,5]
 * 输出: 1
 * 
 * 示例 2：
 * 
 * 输入: [2,2,2,0,1]
 * 输出: 0
 * 
 * 说明：
 * 
 * 
 * 这道题是 寻找旋转排序数组中的最小值 的延伸题目。
 * 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
 * 
 * 
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function (nums) {
    return solution2(nums)
};

// 二分查找
function solution2 (nums) {
    var i = 0, j = nums.length - 1
    while (i < j) {
        const m = i + ((j - i) >>> 1);
        if (nums[m] > nums[j]) {
            i = m + 1
        } else if (nums[m] < nums[j]) {
            j = m
        } else {
            j = j - 1
        }
    }

    return nums[i]
}

// 双指针
function solution1 (nums) {
    if (!nums.length) {
        return
    }

    var p = 0, q = 0;
    for (; p < nums.length;) {
        q = p + 1;
        if (q < nums.length) {
            if (nums[p] <= nums[q]) {
                p++
            } else {
                return nums[q]
            }
        } else {
            return Math.min(nums[p], nums[0])
        }
    }
}
// @lc code=end

