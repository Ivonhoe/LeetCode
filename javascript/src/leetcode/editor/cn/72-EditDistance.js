/*
 * @lc app=leetcode.cn id=72 lang=javascript
 *
 * [72] 编辑距离
 *
 * https://leetcode-cn.com/problems/edit-distance/description/
 *
 * algorithms
 * Hard (59.97%)
 * Likes:    1191
 * Dislikes: 0
 * Total Accepted:    88K
 * Total Submissions: 146.7K
 * Testcase Example:  '"horse"\n"ros"'
 *
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 
 * 你可以对一个单词进行如下三种操作：
 * 
 * 
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 
 * 
 * 示例 2：
 * 
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * 
 * 
 */

// @lc code=start
/**
 * @param {string} word1
 * @param {string} word2
 * @return {number}
 */
var minDistance = function (word1, word2) {
    return solution1(word1, word2)
};

// 动态规划
// 如何打印编辑过程?
var solution1 = function (word1, word2) {
    var length1 = word1.length
    var length2 = word2.length

    if (length1 * length2 == 0) {
        return length1 + length2
    }

    var dp = new Array(length1 + 1)
    for (let i = 0; i < dp.length; i++) {
        dp[i] = new Array(length2 + 1)
    }

    for (let i = 0; i <= length1; i++) {
        dp[i][0] = i
    }

    for (let i = 0; i <= length2; i++) {
        dp[0][i] = i
    }

    for (let i = 1; i <= length1; i++) {
        for (let j = 1; j <= length2; j++) {
            if (word1[i - 1] == word2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1]
            } else {
                dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1
            }
        }
    }

    return dp[length1][length2]
}
// @lc code=end