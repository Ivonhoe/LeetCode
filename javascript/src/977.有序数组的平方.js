/*
 * @lc app=leetcode.cn id=977 lang=javascript
 *
 * [977] 有序数组的平方
 *
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/description/
 *
 * algorithms
 * Easy (71.64%)
 * Likes:    162
 * Dislikes: 0
 * Total Accepted:    80K
 * Total Submissions: 108.9K
 * Testcase Example:  '[-4,-1,0,3,10]'
 *
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 
 * 
 * 示例 2：
 * 
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 * 
 * 
 */

// @lc code=start
/**
 * @param {number[]} A
 * @return {number[]}
 */
var sortedSquares = function (A) {
    var temp = []
    var min = Number.MAX_VALUE
    var minIndex = -1
    for (let i = 0; i < A.length; i++) {
        temp.push(Math.pow(A[i], 2))
        if (temp[i] < min) {
            min = temp[i]
            minIndex = i
        }
    }

    var result = []
    var p = minIndex - 1,
        q = minIndex + 1
    result.push(min)
    while (true) {
        if (p >= 0 && q < A.length) {
            if (temp[p] < temp[q]) {
                result.push(temp[p--])
            } else {
                result.push(temp[q++])
            }
        } else if (p < 0 && q < A.length) {
            result.push(temp[q++])
        } else if (p >= 0 && q >= A.length) {
            result.push(temp[p--])
        } else {
            break
        }
    }
    return result
};
// @lc code=end