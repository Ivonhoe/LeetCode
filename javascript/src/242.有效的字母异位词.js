/*
 * @lc app=leetcode.cn id=242 lang=javascript
 *
 * [242] 有效的字母异位词
 *
 * https://leetcode-cn.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (61.83%)
 * Likes:    268
 * Dislikes: 0
 * Total Accepted:    149.7K
 * Total Submissions: 242.1K
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 
 * 示例 1:
 * 
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * 
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * 
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function (s, t) {
    var sCountMap = new Map();
    for (let i = 0; i < s.length; i++) {
        var temp = sCountMap.get(s[i])
        if (temp == undefined) {
            temp = 1;
        } else {
            temp++;
        }
        sCountMap.set(s[i], temp)
    }

    for (let i = 0; i < t.length; i++) {
        var temp = sCountMap.get(t[i])
        if (temp == undefined || temp <= 0) {
            return false
        } else if (temp > 1) {
            sCountMap.set(t[i], --temp)
        } else {
            sCountMap.delete(t[i])
        }
    }

    return sCountMap.size == 0
};
// @lc code=end