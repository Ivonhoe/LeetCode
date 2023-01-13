package leetcode.editor.cn;

/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] Reverse Integer
 *
 * https://leetcode-cn.com/problems/reverse-integer/description/
 *
 * algorithms
 * Medium (35.16%)
 * Likes:    3737
 * Dislikes: 0
 * Total Accepted:    1.1M
 * Total Submissions: 3.2M
 * Testcase Example:  '123'
 *
 * Given a signed 32-bit integer x, return x with its digits reversed. If
 * reversing x causes the value to go outside the signed 32-bit integer range
 * [-2^31, 2^31 - 1], then return 0.
 * 
 * Assume the environment does not allow you to store 64-bit integers (signed
 * or unsigned).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: x = 123
 * Output: 321
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: x = -123
 * Output: -321
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: x = 120
 * Output: 21
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * -2^31 <= x <= 2^31 - 1
 * 
 * 
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        int ans = 0;
        int last = 0;
        while (x != 0) {
            int temp = x % 10;
            last = ans;
            ans = ans * 10 + temp;

            // 判断整数溢出
            if (last != ans / 10) {
                return 0;
            }
            x = x / 10;
        }

        return ans;
    }
}
// @lc code=end
