/*
 * @lc app=leetcode.cn id=77 lang=javascript
 *
 * [77] 组合
 *
 * https://leetcode-cn.com/problems/combinations/description/
 *
 * algorithms
 * Medium (75.87%)
 * Likes:    433
 * Dislikes: 0
 * Total Accepted:    113.3K
 * Total Submissions: 149.3K
 * Testcase Example:  '4\n2'
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 
 * 示例:
 * 
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function (n, k) {
    var ans = [];

    if (k <= 0 || n < k) {
        return ans;
    }

    var p = [];
    dfs(n, k, 1, p, ans);
    return ans;
};

var dfs = function (n, k, begin, path, result) {
    if (path.length == k) {
        result.push([...path]);
        return;
    }

    for (let i = begin; i <= n; i++) {
        path.push(i);
        dfs(n, k, i + 1, path, result);
        path.pop();
    }
}
// @lc code=end