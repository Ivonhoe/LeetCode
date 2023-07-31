/*
 * @lc app=leetcode.cn id=1 lang=javascript
 *
 * [1] 两数之和
 *
 * https://leetcode-cn.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (46.05%)
 * Likes:    7614
 * Dislikes: 0
 * Total Accepted:    812.5K
 * Total Submissions: 1.7M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 
 * 示例:
 * 
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 
 * 
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (nums, target) {
    return solution2(nums, target);
};

// O(N^2)的时间复杂度
var solotion1 = function (nums, target) {
    var result = new Array;
    var length = nums.length;
    for (var i = 0; i < length; i++) {
        for (var j = i + 1; j < length; j++) {
            if (nums[i] + nums[j] == target) {
                result[0] = i;
                result[1] = j;
                return result;
            }
        }
    }

    return result;
}

// O(N), 空间换时间
var solution2 = function (nums, target) {
    var mapCache = new Map()
    for (let i = 0; i < nums.length; i++) {
        if (mapCache.get(target - nums[i]) != null) {
            return [mapCache.get(target - nums[i]), i]
        }
        mapCache.set(nums[i], i)
    }

    return []
}

var solution3 = function (nums, target, i, map = {}) {
    const mapCache = map
    console.log("map cache:" + mapCache.length)
    if (mapCache[target - nums[i]] != null) {
        return [mapCache[target - nums[i]], i]
    } else {
        mapCache[nums[i]] = i
        i++
        if (i < nums.length) {
            return solution3(nums, target, i, mapCache)
        } else {
            return []
        }
    }
}
// @lc code=end