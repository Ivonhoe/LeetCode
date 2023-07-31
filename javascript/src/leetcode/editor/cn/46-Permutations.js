/*
 * @lc app=leetcode.cn id=46 lang=javascript
 *
 * [46] 全排列
 *
 * https://leetcode-cn.com/problems/permutations/description/
 *
 * algorithms
 * Medium (77.01%)
 * Likes:    955
 * Dislikes: 0
 * Total Accepted:    207.2K
 * Total Submissions: 269K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,2,3]
 * 输出:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function (nums) {
    var ans = [];
    if (nums == null || nums.length < 1) {
        return ans;
    }

    var used = new Map();
    dfs(nums, 0, used, [], ans);
    return ans;
};

var dfs = function (nums, depth, used, path, result) {
    if (depth == nums.length) {
        result.push([...path]);
        return;
    }

    for (let i = 0; i < nums.length; i++) {
        if (!used[i]) {
            used[i] = true;
            path.push(nums[i])
            dfs(nums, depth + 1, used, path, result)
            used[i] = false;
            path.pop()
        }
    }
}
// @lc code=end