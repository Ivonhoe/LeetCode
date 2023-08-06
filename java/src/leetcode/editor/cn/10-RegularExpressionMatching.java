/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] Regular Expression Matching
 *
 * https://leetcode.cn/problems/regular-expression-matching/description/
 *
 * algorithms
 * Hard (30.73%)
 * Likes:    3667
 * Dislikes: 0
 * Total Accepted:    379.8K
 * Total Submissions: 1.2M
 * Testcase Example:  '"aa"\n"a"'
 *
 * Given an input string s and a pattern p, implement regular expression
 * matching with support for '.' and '*' where:
 * 
 * 
 * '.' Matches any single character.​​​​
 * '*' Matches zero or more of the preceding element.
 * 
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "aa", p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'.
 * Therefore, by repeating 'a' once, it becomes "aa".
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "ab", p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 20
 * 1 <= p.length <= 20
 * s contains only lowercase English letters.
 * p contains only lowercase English letters, '.', and '*'.
 * It is guaranteed for each appearance of the character '*', there will be a
 * previous valid character to match.
 * 
 * 
 */

// @lc code=start
class Solution {

    private boolean match = false;

    public boolean isMatch(String s, String p) {
        return match(s, p);
    }

    private boolean match(String s, String p) {
        backtrackRight(s.toCharArray(), p.toCharArray(), 0, 0);
        return match;
    }

    // 回溯法
    void backtrackRight(char[] s, char[] p, int si, int pj) {
        if (pj == p.length) {// 正则表达式到末尾了
            if (si == s.length) {
                match = true;
            }
            return;
        }

        if (pj < p.length - 1 && p[pj + 1] == '*') {
            backtrackRight(s, p, si, pj + 2);

            while (si < s.length && (p[pj] == '.' || s[si] == p[pj])) {
                backtrackRight(s, p, si + 1, pj + 2);
                si++;
            }
        } else if (si < s.length && (p[pj] == '.' || s[si] == p[pj])) {
            backtrackRight(s, p, si + 1, pj + 1);
        }
    }

    // 王争例题解法，和本题不匹配
    private boolean solution1(String s, String p) {
        backtrack(s.toCharArray(), p.toCharArray(), 0, 0);
        return match;
    }

    void backtrack(char[] s, char[] p, int si, int pj) {
        if (pj == p.length) {// 正则表达式到末尾了
            if (si == s.length) {
                match = true;
            }
            return;
        }

        if (p[pj] == '*') {
            // 匹配多个字符
            for (int k = 0; si + k <= s.length; k++) {
                backtrack(s, p, si + k, pj + 1);
            }
        } else if (p[pj] == '.') {
            // 匹配0个字符
            backtrack(s, p, si, pj + 1);
            if (si < s.length) {
                // 匹配1个字符
                backtrack(s, p, si + 1, pj + 1);
            }
        } else if (si < s.length && s[si] == p[pj]) {
            backtrack(s, p, si + 1, pj + 1);
        }
    }
}
// @lc code=end
