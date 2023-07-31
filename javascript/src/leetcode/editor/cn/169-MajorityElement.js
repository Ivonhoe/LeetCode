/*
 * @lc app=leetcode.cn id=169 lang=javascript
 *
 * [169] 多数元素
 *
 * https://leetcode-cn.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (64.92%)
 * Likes:    794
 * Dislikes: 0
 * Total Accepted:    232.7K
 * Total Submissions: 358.4K
 * Testcase Example:  '[3,2,3]'
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: [3,2,3]
 * 输出: 3
 * 
 * 示例 2:
 * 
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * 
 * 
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function (nums) {
    return solution2(nums)
};

var solution2 = function (nums) {
    var map = new Map();
    var half = parseInt(nums.length / 2)
    for (let i = 0; i < nums.length; i++) {
        let value = map[nums[i]]
        if (value == null) {
            value = 1;
        } else {
            value++;
        }
        map[nums[i]] = value;
        if (value > half) {
            return nums[i]
        }
    }
}

var solution1 = function (nums) {
    if (nums == null) {
        return 0;
    }
    var sort = function sortNumber(a, b) {
        return a - b
    }
    nums.sort(sort)
    return nums[parseInt(nums.length / 2)]
}
// @lc code=end