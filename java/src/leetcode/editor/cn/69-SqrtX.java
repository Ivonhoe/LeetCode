package leetcode.editor.cn;

/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] Sqrt(x)
 *
 * https://leetcode-cn.com/problems/sqrtx/description/
 *
 * algorithms
 * Easy (38.95%)
 * Likes:    1095
 * Dislikes: 0
 * Total Accepted:    588.5K
 * Total Submissions: 1.5M
 * Testcase Example:  '4'
 *
 * Given a non-negative integer x, compute and return the square root of x.
 * 
 * Since the return type is an integer, the decimal digits are truncated, and
 * only the integer part of the result is returned.
 * 
 * Note: You are not allowed to use any built-in exponent function or operator,
 * such as pow(x, 0.5) or x ** 0.5.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: x = 4
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part
 * is truncated, 2 is returned.
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= x <= 2^31 - 1
 * 
 * 
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int low = 1;
        int high = x / 2 + 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long mid2 = (long) mid * mid;
            if (mid2 == x) {
                return mid;
            } else if (mid2 < x) {
                long mid22 = ((long) mid + 1) * (mid + 1);
                if (mid22 <= x) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
// @lc code=end
