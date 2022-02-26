package leetcode.editor.cn;

/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] Power of Two
 *
 * https://leetcode-cn.com/problems/power-of-two/description/
 *
 * algorithms
 * Easy (50.53%)
 * Likes:    462
 * Dislikes: 0
 * Total Accepted:    201.5K
 * Total Submissions: 398.8K
 * Testcase Example:  '1'
 *
 * Given an integer n, return true if it is a power of two. Otherwise, return
 * false.
 * 
 * An integer n is a power of two, if there exists an integer x such that n ==
 * 2^x.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 1
 * Output: true
 * Explanation: 2^0 = 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 16
 * Output: true
 * Explanation: 2^4 = 16
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: n = 3
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * -2^31 <= n <= 2^31 - 1
 * 
 * 
 * 
 * Follow up: Could you solve it without loops/recursion?
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
// @lc code=end

