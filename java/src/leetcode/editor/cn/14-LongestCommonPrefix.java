/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] Longest Common Prefix
 *
 * https://leetcode.cn/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (43.40%)
 * Likes:    2851
 * Dislikes: 0
 * Total Accepted:    1.1M
 * Total Submissions: 2.6M
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * Write a function to find the longest common prefix string amongst an array
 * of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 * 
 * 
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null) {
            return "";
        }

        int length = Integer.MAX_VALUE;
        for (String str : strs) {
            length = Math.min(str.length(), length);
        }

        String ans = new String();
        int index = 0;
        while (index < length) {
            char c = strs[0].charAt(index);
            for (String str : strs) {
                if (str.charAt(index) != c) {
                    return ans;
                }
            }
            ans += c;
            index++;
        }

        return ans;
    }
}
// @lc code=end
