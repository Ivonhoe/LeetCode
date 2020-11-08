/*
 * @lc app=leetcode.cn id=47 lang=javascript
 *
 * [47] 全排列 II
 *
 * https://leetcode-cn.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (62.17%)
 * Likes:    519
 * Dislikes: 0
 * Total Accepted:    119.1K
 * Total Submissions: 191.6K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * ⁠[1,2,1],
 * ⁠[2,1,1]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * -10 
 * 
 * 
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function (nums) {
    var ans = [];
    if (nums == null || nums.length < 1) {
        return ans;
    }

    nums.sort(sortNumber);
    var used = new Map();
    dfs(nums, 0, used, [], ans);
    return ans;
};

function sortNumber(a, b) {
    return a - b
}

var dfs = function (nums, depth, used, path, result) {
    if (depth == nums.length) {
        result.push([...path]);
        return;
    }

    for (let i = 0; i < nums.length; i++) {
        // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
        // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
        if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
            continue;
        }

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