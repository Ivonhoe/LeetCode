/*
 * @lc app=leetcode.cn id=41 lang=javascript
 *
 * [41] 缺失的第一个正数
 *
 * https://leetcode-cn.com/problems/first-missing-positive/description/
 *
 * algorithms
 * Hard (38.45%)
 * Likes:    651
 * Dislikes: 0
 * Total Accepted:    73.5K
 * Total Submissions: 182.9K
 * Testcase Example:  '[1,2,0]'
 *
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: [1,2,0]
 * 输出: 3
 * 
 * 
 * 示例 2:
 * 
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 
 * 
 * 示例 3:
 * 
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 * 
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var firstMissingPositive = function (nums) {
    for (var i = 0; i < nums.length; i++) {
        while (nums[i] > 0 && nums[i] <= nums.length
            && nums[nums[i] - 1] != nums[i]) {
            var temp = nums[nums[i] - 1];
            nums[nums[i] - 1] = nums[i];
            nums[i] = temp;
        }
    }

    for (var i = 0; i < nums.length; i++) {
        if (i + 1 != nums[i]) {
            return i + 1
        }
    }

    return nums.length + 1
};
// @lc code=end

