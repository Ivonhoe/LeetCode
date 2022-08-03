package leetcode.editor.cn;

/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] Valid Perfect Square
 *
 * https://leetcode-cn.com/problems/valid-perfect-square/description/
 *
 * algorithms
 * Easy (44.85%)
 * Likes:    420
 * Dislikes: 0
 * Total Accepted:    174K
 * Total Submissions: 388K
 * Testcase Example:  '16'
 *
 * Given a positive integer num, write a function which returns True if num is
 * a perfect square else False.
 * 
 * Follow up: Do not use any built-in library function such as sqrt.
 * 
 * 
 * Example 1:
 * Input: num = 16
 * Output: true
 * Example 2:
 * Input: num = 14
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= num <= 2^31 - 1
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        int low = 1, high = num;
        while (low <= high) {
            int mid = (low + high) >> 1;

            long mid2 = (long) mid * mid;
            if (mid2 == num) {
                return true;
            } else if (mid2 < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}
// @lc code=end
