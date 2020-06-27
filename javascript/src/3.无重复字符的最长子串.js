/*
 * @lc app=leetcode.cn id=3 lang=javascript
 *
 * [3] 无重复字符的最长子串
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (34.81%)
 * Likes:    3861
 * Dislikes: 0
 * Total Accepted:    538.3K
 * Total Submissions: 1.5M
 * Testcase Example:  '"abcabcbb"'
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 示例 1:
 * 
 * 输入: "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 
 * 示例 3:
 * 
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function (s) {
    return solution1(s)
};

function solution1 (s) {
    var n = s.length, ans = 0;
    var map = new Map()
    // try to extend the range [i, j]
    for (var j = 0, i = 0; j < n; j++) {
        if (map.has(s.charCodeAt(j))) {
            i = Math.max(map.get(s.charCodeAt(j)), i);
        }
        ans = Math.max(ans, j - i + 1);
        map.set(s.charCodeAt(j), j + 1);
    }

    return ans
}

var CHAR = '\0'

function solution2 (s) {
    if (s == null || s.length < 1) {
        return 0;
    }

    var length = s.length;
    var tempContainer = [];
    clearCharList(tempContainer);

    var maxLength = 0;
    for (var i = 0; i < length; i++) {
        for (var j = i; j < length; j++) {
            var foundInTempList = foundInList(tempContainer, s.charCodeAt(j));
            if (foundInTempList) {
                clearCharList(tempContainer);
                if (j - i > maxLength) {
                    maxLength = j - i;
                }
                break;
            } else {
                tempContainer[j - i] = s.charCodeAt(j);
                if (j == length - 1) {
                    if (j - i + 1 > maxLength) {
                        maxLength = j - i + 1;
                    }
                }
            }
        }
    }
    return maxLength;
}

function clearCharList (charList) {
    if (charList == null || charList.length < 1) {
        return;
    }

    for (var i = 0; i < charList.length; i++) {
        charList[i] = CHAR;
    }
}

function foundInList (charList, a) {
    if (charList == null || charList.length < 1) {
        return false;
    }

    for (var i = 0; i < charList.length; i++) {
        var c = charList[i]
        if (c == CHAR) {
            return false;
        } else if (a == c) {
            return true;
        }
    }

    return false;
}
// @lc code=end

