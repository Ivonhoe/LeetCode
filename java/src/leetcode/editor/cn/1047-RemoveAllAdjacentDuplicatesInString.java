package leetcode.editor.cn;

import java.util.Stack;

/*
 * @lc app=leetcode.cn id=1047 lang=java
 *
 * [1047] Remove All Adjacent Duplicates In String
 *
 * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/description/
 *
 * algorithms
 * Easy (72.58%)
 * Likes:    405
 * Dislikes: 0
 * Total Accepted:    165.4K
 * Total Submissions: 227.5K
 * Testcase Example:  '"abbaca"'
 *
 * You are given a string s consisting of lowercase English letters. A
 * duplicate removal consists of choosing two adjacent and equal letters and
 * removing them.
 * 
 * We repeatedly make duplicate removals on s until we no longer can.
 * 
 * Return the final string after all such duplicate removals have been made. It
 * can be proven that the answer is unique.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abbaca"
 * Output: "ca"
 * Explanation: 
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent
 * and equal, and this is the only possible move.  The result of this move is
 * that the string is "aaca", of which only "aa" is possible, so the final
 * string is "ca".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "azxxzy"
 * Output: "ay"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^5
 * s consists of lowercase English letters.
 * 
 * 
 */

// @lc code=start
class Solution {
    public String removeDuplicates(String s) {
        return solution2(s);
    }

    // 使用数组
    private String solution2(String s) {
        int n = s.length();
        char[] cs = new char[n];
        int i = -1;
        for (char c : s.toCharArray()) {
            if (i >= 0 && cs[i] == c) {
                i--;
            } else {
                cs[++i] = c;
            }
        }
        return new String(cs, 0, i + 1);
    }

    // 使用栈或双端队列
    private String solution1(String s) {
        if (s == null) {
            return s;
        }
        // 或者使用双端队列
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
                continue;
            } else {
                stack.push(c);
            }
        }

        String ans = "";
        while (!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }
        return ans;
    }
}
// @lc code=end
