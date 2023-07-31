/*
 * @lc app=leetcode.cn id=66 lang=javascript
 *
 * [66] 加一
 *
 * https://leetcode-cn.com/problems/plus-one/description/
 *
 * algorithms
 * Easy (45.55%)
 * Likes:    561
 * Dislikes: 0
 * Total Accepted:    212.9K
 * Total Submissions: 467.4K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * 
 * 
 */

// @lc code=start
/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function (digits) {
    return solution2(digits)
};

var solution2 = function (digits) {
    for (let i = digits.length - 1; i >= 0; i--) {
        let number = digits[i] + 1
        digits[i] = number % 10
        if (digits[i] != 0) {
            break
        }
    }

    if (digits[0] == 0) {
        var result = [digits.length + 1]
        result[0] = 1
        for (let i = 1; i <= digits.length; i++) {
            result[i] = digits[i - 1]
        }
        return result
    } else {
        return digits
    }
}
var solution1 = function (digits) {
    let number = BigInt(digits.join(''));
    let string = String(number + 1n);
    let ary = string.split('');

    return ary.map(str => Number(str));
}
// @lc code=end