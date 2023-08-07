/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] Palindrome Partitioning
 *
 * https://leetcode.cn/problems/palindrome-partitioning/description/
 *
 * algorithms
 * Medium (73.40%)
 * Likes:    1589
 * Dislikes: 0
 * Total Accepted:    310.6K
 * Total Submissions: 423.1K
 * Testcase Example:  '"aab"'
 *
 * Given a string s, partition s such that every substring of the partition is
 * a palindrome. Return all possible palindrome partitioning of s.
 * 
 * 
 * Example 1:
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * Example 2:
 * Input: s = "a"
 * Output: [["a"]]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 * 
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrace(s, 0, new ArrayList<>());
        return ans;
    }

    private void backtrace(String s, int k, List<String> path) {
        if (k == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = k; i < s.length(); i++) {
            if (!checkPalindrome(s.toCharArray(), k, i)) {
                continue;
            }

            path.add(s.substring(k, i + 1));
            backtrace(s, i + 1, path);
            path.remove(path.size() - 1);
        }
    }

    private boolean checkPalindrome(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
// @lc code=end
