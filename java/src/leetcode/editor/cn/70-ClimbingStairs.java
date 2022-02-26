package leetcode.editor.cn;

/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] Climbing Stairs
 *
 * https://leetcode-cn.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (53.46%)
 * Likes:    2211
 * Dislikes: 0
 * Total Accepted:    710.1K
 * Total Submissions: 1.3M
 * Testcase Example:  '2'
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 45
 * 
 * 
 */

// @lc code=start
class Solution {
    /// 备忘录
    private int[] mem;

    public int climbStairs(int n) {
        mem = new int[n + 1];
        return f(n);
    }

    private int f(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (mem[n] != 0)
            return mem[n];
        mem[n] = f(n - 1) + f(n - 2);
        return mem[n];
    }
}
// @lc code=end
