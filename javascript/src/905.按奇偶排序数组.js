/*
 * @lc app=leetcode.cn id=905 lang=javascript
 *
 * [905] 按奇偶排序数组
 *
 * https://leetcode-cn.com/problems/sort-array-by-parity/description/
 *
 * algorithms
 * Easy (68.86%)
 * Likes:    151
 * Dislikes: 0
 * Total Accepted:    38.1K
 * Total Submissions: 55.3K
 * Testcase Example:  '[3,1,2,4]'
 *
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 * 
 * 你可以返回满足此条件的任何数组作为答案。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 * 
 * 
 */

// @lc code=start
/**
 * @param {number[]} A
 * @return {number[]}
 */
var sortArrayByParity = function (A) {
    return solution2(A)
};

function solution2 (A) {
    if (A.length < 1) {
        return []
    }

    var last = A.length - 1
    for (var i = 0; i < last; i++) {
        if (A[i] % 2 == 1) {
            swap(i, last, A)
            last--
            i--
        }
    }

    return A
}

function swap (i, last, A) {
    var temp = A[i]
    A[i] = A[last]
    A[last] = temp
}

function solution1 (A) {
    if (A.length < 1) {
        return []
    }

    var length = A.length
    var result = []
    var index = []
    var index2 = []
    for (var i = 0; i < length; i++) {
        if (A[i] % 2 == 0) {
            index.push(i)
        } else {
            index2.push(i)
        }
    }
    for (var i = 0; i < index.length; i++) {
        result.push(A[index[i]])
    }
    for (var i = 0; i < index2.length; i++) {
        result.push(A[index2[i]])
    }

    return result
}
// @lc code=end

