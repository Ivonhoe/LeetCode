/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] Generate Parentheses
 *
 * https://leetcode.cn/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (77.45%)
 * Likes:    3329
 * Dislikes: 0
 * Total Accepted:    724.1K
 * Total Submissions: 935K
 * Testcase Example:  '3'
 *
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * 
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 * Input: n = 1
 * Output: ["()"]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 8
 * 
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrace(n, 0, 0, new ArrayList<Character>());
        return ans;
    }

    // 回溯法, 左右括号计数
    private void backtrace(int n, int left, int right, List<Character> path) {
        if (path.size() == 2 * n) {
            StringBuffer sb = new StringBuffer();
            for (Character c : path) {
                sb.append(c);
            }
            ans.add(sb.toString());
            return;
        }

        if (left < n) {
            path.add('(');
            backtrace(n, left + 1, right, path);
            path.remove(path.size() - 1);
        }

        if (right < left) {
            path.add(')');
            backtrace(n, left, right + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end
