/*
 * @lc app=leetcode.cn id=70 lang=javascript
 *
 * [70] 爬楼梯
 *
 * https://leetcode-cn.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (49.81%)
 * Likes:    1100
 * Dislikes: 0
 * Total Accepted:    231.3K
 * Total Submissions: 463.9K
 * Testcase Example:  '2'
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * 注意：给定 n 是一个正整数。
 * 
 * 示例 1：
 * 
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 
 * 示例 2：
 * 
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * 
 * 
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function (n) {
    return solution2(n)
};
// @lc code=end

var solution0 = function (n) {
    var data = []
    data[0] = 1
    data[1] = 1
    for (var i = 2; i <= n; i++) {
        data[i] = data[i - 1] + data[i - 2]
    }

    return data[n]
}

/// 递归超时
var solution1 = function (n) {
    if (n == 0 || n == 1) {
        return 1;
    }

    return solution1(n - 1) + solution1(n - 2)
}

var solution2 = function (n) {
    var p = 0
    var q = 0
    var r = 1

    for (var i = 1; i <= n; i++) {
        p = q;
        q = r;
        r = p + q;
    }

    return r
}