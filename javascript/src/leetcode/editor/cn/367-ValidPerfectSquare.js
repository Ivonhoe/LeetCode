/*
 * @lc app=leetcode.cn id=367 lang=javascript
 *
 * [367] 有效的完全平方数
 *
 * https://leetcode-cn.com/problems/valid-perfect-square/description/
 *
 * algorithms
 * Easy (43.55%)
 * Likes:    178
 * Dislikes: 0
 * Total Accepted:    48K
 * Total Submissions: 110.3K
 * Testcase Example:  '16'
 *
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * 
 * 说明：不要使用任何内置的库函数，如  sqrt。
 * 
 * 示例 1：
 * 
 * 输入：16
 * 输出：True
 * 
 * 示例 2：
 * 
 * 输入：14
 * 输出：False
 * 
 * 
 */

// @lc code=start
/**
 * @param {number} num
 * @return {boolean}
 */
var isPerfectSquare = function (num) {
    if (num < 2) {
        return true
    }

    var left = 2,
        right = num / 2
    while (left <= right) {
        let x = parseInt(left + (right - left) / 2)
        let squared = x * x
        if (squared > num) {
            right = x - 1
        } else if (squared < num) {
            left = x + 1
        } else {
            return true
        }
    }

    return false
};
// @lc code=end