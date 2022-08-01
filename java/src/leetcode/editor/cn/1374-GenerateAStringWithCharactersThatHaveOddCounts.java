package leetcode.editor.cn;

/*
 * @lc app=leetcode.cn id=1374 lang=java
 *
 * [1374] Generate a String With Characters That Have Odd Counts
 *
 * https://leetcode-cn.com/problems/generate-a-string-with-characters-that-have-odd-counts/description/
 *
 * algorithms
 * Easy (74.22%)
 * Likes:    61
 * Dislikes: 0
 * Total Accepted:    44.1K
 * Total Submissions: 57K
 * Testcase Example:  '4'
 *
 * Given an integer n, return a string with n characters such that each
 * character in such string occurs an odd number of times.
 * 
 * The returned string must contain only lowercase English letters. If there
 * are multiples valid strings, return any of them.  
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 4
 * Output: "pppz"
 * Explanation: "pppz" is a valid string since the character 'p' occurs three
 * times and the character 'z' occurs once. Note that there are many other
 * valid strings such as "ohhh" and "love".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 2
 * Output: "xy"
 * Explanation: "xy" is a valid string since the characters 'x' and 'y' occur
 * once. Note that there are many other valid strings such as "ag" and "ur".
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: n = 7
 * Output: "holasss"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 500
 * 
 * 
 */

// @lc code=start
class Solution {
    public String generateTheString(int n) {
        StringBuffer ans = new StringBuffer();
        int k = n % 2;
        if (k == 0) {
            for (int i = 0; i < n; i++) {
                if (i < n - 1) {
                    ans.append('x');
                } else {
                    ans.append('y');
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                ans.append('x');
            }
        }

        return ans.toString();
    }
}
// @lc code=end
