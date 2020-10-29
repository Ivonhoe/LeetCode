/*
 * @lc app=leetcode.cn id=412 lang=javascript
 *
 * [412] Fizz Buzz
 *
 * https://leetcode-cn.com/problems/fizz-buzz/description/
 *
 * algorithms
 * Easy (64.95%)
 * Likes:    73
 * Dislikes: 0
 * Total Accepted:    48.2K
 * Total Submissions: 74.2K
 * Testcase Example:  '1'
 *
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * 
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * 
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * 
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 * 
 * 示例：
 * 
 * n = 15,
 * 
 * 返回:
 * [
 * ⁠   "1",
 * ⁠   "2",
 * ⁠   "Fizz",
 * ⁠   "4",
 * ⁠   "Buzz",
 * ⁠   "Fizz",
 * ⁠   "7",
 * ⁠   "8",
 * ⁠   "Fizz",
 * ⁠   "Buzz",
 * ⁠   "11",
 * ⁠   "Fizz",
 * ⁠   "13",
 * ⁠   "14",
 * ⁠   "FizzBuzz"
 * ]
 * 
 * 
 */

// @lc code=start
/**
 * @param {number} n
 * @return {string[]}
 */
var fizzBuzz = function (n) {
    return solution3(n)
};

var solution3 = function (n) {
    const result = [];
    for (let i = 1; i < n + 1; i++) {
        let str = '';
        str += i % 3 ? '' : 'Fizz';
        str += i % 5 ? '' : 'Buzz';
        if (!str) str += i;
        result.push(str);
    }
    return result;
}

var solution2 = function (n) {
    return Array.from({
        length: n
    }, (t, i) => (t = (++i % 3 ? '' : 'Fizz') + (i % 5 ? '' : 'Buzz')) ? t : '' + i)
}
// 遍历
var solution1 = function (n) {
    var result = []
    for (let i = 1; i <= n; i++) {
        if (i % 3 == 0 && i % 5 == 0) {
            result.push('FizzBuzz')
        } else if (i % 3 == 0) {
            result.push('Fizz')
        } else if (i % 5 == 0) {
            result.push('Buzz')
        } else {
            result.push("" + i)
        }
    }

    return result;
}
// @lc code=end