/*
 * @lc app=leetcode.cn id=1002 lang=javascript
 *
 * [1002] 查找常用字符
 *
 * https://leetcode-cn.com/problems/find-common-characters/description/
 *
 * algorithms
 * Easy (68.96%)
 * Likes:    138
 * Dislikes: 0
 * Total Accepted:    26.1K
 * Total Submissions: 35.8K
 * Testcase Example:  '["bella","label","roller"]'
 *
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3
 * 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * 
 * 你可以按任意顺序返回答案。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 
 * 
 * 示例 2：
 * 
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 * 
 * 
 */

// @lc code=start
/**
 * @param {string[]} A
 * @return {string[]}
 */
var commonChars = function (A) {
    return solution2(A)
};

// 穷举查找法
var solution1 = function (A) {
    if (A == null || A.length < 1) {
        return []
    }

    var firstStr = A[0]
    var result = []
    for (let i = 0; i < firstStr.length; i++) {
        var c = firstStr[i]
        var success = true
        for (let j = 1; j < A.length; j++) {
            var str = A[j]
            var index = str.indexOf(c)
            if (index < 0) {
                success = false
                break
            }
        }
        if (success) {
            result.push(c)
            for (let k = 1; k < A.length; k++) {
                var str = A[k]
                var n = str.indexOf(c)
                A[k] = str.substr(0, n) + '/' + str.substr(n + 1, str.length - 1 - n);
            }
        }
    }

    return result
}

// 计数
var solution2 = function (A) {
    var minfreq = [26]
    for (let i = 0; i < 26; i++) {
        minfreq[i] = Number.MAX_VALUE
    }

    for (let w in A) {
        var freq = [26]

        for (let i = 0; i < 26; i++) {
            freq[i] = 0
        }

        var word = A[w]
        for (let i = 0; i < word.length; i++) {
            var c = word[i]
            var index = c.charCodeAt() - 'a'.charCodeAt()
            freq[index] = freq[index] + 1
        }

        for (let i = 0; i < 26; i++) {
            minfreq[i] = Math.min(minfreq[i], freq[i])
        }
    }

    var result = []
    for (let i = 0; i < 26; i++) {
        for (let j = 0; j < minfreq[i]; j++) {
            result.push(String.fromCharCode(i + 97))
        }
    }

    return result
}
// @lc code=end