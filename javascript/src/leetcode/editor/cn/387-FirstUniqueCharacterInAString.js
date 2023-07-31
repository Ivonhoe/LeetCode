/*
 * @lc app=leetcode.cn id=387 lang=javascript
 *
 * [387] 字符串中的第一个唯一字符
 *
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/description/
 *
 * algorithms
 * Easy (47.86%)
 * Likes:    299
 * Dislikes: 0
 * Total Accepted:    116K
 * Total Submissions: 241.5K
 * Testcase Example:  '"leetcode"'
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 
 * 
 * 
 * 示例：
 * 
 * s = "leetcode"
 * 返回 0
 * 
 * s = "loveleetcode"
 * 返回 2
 * 
 * 
 * 
 * 
 * 提示：你可以假定该字符串只包含小写字母。
 * 
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function (s) {
    return solution2(s)
};

var solution2 = function (s) {
    let countingSort = (arr, maxValue) => {
        let bucket = new Array(maxValue).fill(0);
        let arrLen = arr.length;
        for (let i = 0; i < arrLen; i++) {
            bucket[arr[i].charCodeAt() - 97]++;
        }
        for (let j = 0; j < arrLen; j++) {
            if (bucket[arr[j].charCodeAt() - 97] == 1) {
                return j;
            }
        }
        return -1;
    }
    return countingSort(s, 26)
}

var solution1 = function (s) {
    var map = new Map()

    for (let i in s) {
        let count = map.get(s[i]) || 0;
        map.set(s[i], count + 1);
    }

    for (let i = 0; i < s.length; i++) {
        if (map[s.charAt(i)] == 1) {
            return i
        }
    }

    return -1
}
// @lc code=end