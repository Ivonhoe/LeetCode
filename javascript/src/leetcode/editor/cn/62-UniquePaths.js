/*
 * @lc app=leetcode.cn id=62 lang=javascript
 *
 * [62] 不同路径
 *
 * https://leetcode-cn.com/problems/unique-paths/description/
 *
 * algorithms
 * Medium (62.40%)
 * Likes:    714
 * Dislikes: 0
 * Total Accepted:    153.6K
 * Total Submissions: 246.1K
 * Testcase Example:  '3\n7'
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 
 * 问总共有多少条不同的路径？
 * 
 * 
 * 
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 
 * 
 * 示例 2:
 * 
 * 输入: m = 7, n = 3
 * 输出: 28
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 10 ^ 9
 * 
 * 
 */

// @lc code=start
/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function (m, n) {
    return solution1(m, n)
};

// 动态规划
var solution1 = function (m, n) {
    if (m == 0 || n == 0) {
        return 1
    }

    var dp = new Array(n)
    for (var i = 0; i < n; i++) {
        dp[i] = new Array(m)
    }

    for (var i = 0; i < m; i++) {
        console.log("i=" + i)
        dp[0][i] = 1
    }

    for (var i = 0; i < n; i++) {
        console.log("222 i=" + i)
        dp[i][0] = 1
    }

    for (var i = 1; i < m; i++) {
        for (var j = 1; j < n; j++) {
            dp[j][i] = dp[j-1][i] + dp[j][i-1]
        }
    }
    return dp[n - 1][m - 1]
}
// @lc code=end